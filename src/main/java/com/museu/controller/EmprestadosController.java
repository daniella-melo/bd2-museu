package com.museu.controller;

import com.museu.dtos.Consulta4Dto;
import com.museu.dtos.EmprestadosPorColecaoDto;
import com.museu.model.Emprestados;
import com.museu.dtos.EmprestadosPorMesDto;
import com.museu.dtos.EmprestadosPorAnoDto;
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

    @RequestMapping("/graficoConsulta4/grafico-collection")
    //Objetos emprestados por coleção
    public String grafico1Consulta4(Model model){
        
        List<EmprestadosPorColecaoDto> resultList = this.service.getListTotalEmprestadosPorColecao();
		Map<String, Integer> consultMap = new LinkedHashMap<>();

        for (EmprestadosPorColecaoDto consultaDto : resultList) {
            
            consultMap.put(consultaDto.getCol(), consultaDto.getQtdobjemprestados().intValue());
        }
		
		model.addAttribute("dataMap", consultMap);
		return "graph-borrowed-objects-collection";
    }

    @RequestMapping("/graficoConsulta4/grafico-mes")
    //Objetos emprestados por mês
    public String grafico2Consulta4(Model model){
        
        List<EmprestadosPorMesDto> resultList = this.service.getListEmprestadosPorMes();
		Map<String, BigInteger> consultMap = new LinkedHashMap<>();

        for (EmprestadosPorMesDto consultaDto : resultList) {
            
            consultMap.put(consultaDto.getMes(), consultaDto.getQtdobjemprestados());
        }
		
		model.addAttribute("dataMap", consultMap);
		return "graph-borrowed-objects-month";
    }

    @RequestMapping("/graficoConsulta4/grafico-ano")
    //Objetos emprestados por ano
    public String grafico3Consulta4(Model model){
        
        List<EmprestadosPorAnoDto> resultList = this.service.getListEmprestadosPorAno();
		Map<String, BigInteger> consultMap = new LinkedHashMap<>();

        for (EmprestadosPorAnoDto consultaDto : resultList) {
            
            consultMap.put(consultaDto.getAno(), consultaDto.getQtdobjemprestados());
        }
		
		model.addAttribute("dataMap", consultMap);
		return "graph-borrowed-objects-year";
    }

    @RequestMapping("/compras/{mes}{ano}")
    public ModelAndView viewPeriodDetails(@PathVariable("mes") int mes, @PathVariable("ano") int ano){
        ModelAndView mv = new ModelAndView("details");
        List<Emprestados> resultList = this.service.getByPeriod(mes,ano);
        mv.addObject("resultList", resultList);
        return mv;
    }
}