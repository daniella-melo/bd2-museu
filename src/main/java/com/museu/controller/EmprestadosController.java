package com.museu.controller;

import com.museu.dtos.Consulta4Dto;
import com.museu.model.Emprestados;
import com.museu.service.EmprestadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.Map;

import java.util.List;


@RequestMapping("/emprestados")
@Controller
public class EmprestadosController {

    @Autowired
    private EmprestadosService service;

    @Autowired
    private Consulta4Dto consulta3Dto;

    @RequestMapping("/consulta4")
    public ModelAndView queryResult4(){
        List<Consulta4Dto> resultList = this.service.getListEmprestadosPorColecao();
        ModelAndView mv = new ModelAndView("consulta4");
        mv.addObject("resultList", resultList);
        return mv;
    }

    @RequestMapping("/graficoConsulta4")
    public String graficoConsulta2(Model model){
        
        List<Consulta4Dto> resultList = this.service.getListEmprestadosPorColecao();
		Map<String, BigInteger> consultMap = new LinkedHashMap<>();

        for (Consulta4Dto consultaDto : resultList) {
            
            consultMap.put(consultaDto.getNomecol(), consultaDto.getQtdobjemprestados());
        }
		
		model.addAttribute("surveyMap", consultMap);
		return "graph-borrowed-objects-month";
    }

    @RequestMapping("/compras/{mes}{ano}")
    public ModelAndView viewPeriodDetails(@PathVariable("mes") int mes, @PathVariable("ano") int ano){
        ModelAndView mv = new ModelAndView("details");
        List<Emprestados> resultList = this.service.getByPeriod(mes,ano);
        mv.addObject("resultList", resultList);
        return mv;
    }
}