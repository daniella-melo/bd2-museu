package com.museu.controller;

import com.museu.dtos.Consulta2Dto;
import com.museu.dtos.Consulta3Dto;
import com.museu.dtos.ObjCompradosPorAnoDto;
import com.museu.dtos.ObjCompradosPorMesDto;

import com.museu.model.Permanentes;
import com.museu.service.PermanentesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import java.util.List;

@RequestMapping("/permanentes")
@Controller
public class PermanentesController {

    @Autowired
    private PermanentesService service;

    @Autowired
    private Consulta3Dto consulta3Dto;

    @RequestMapping("/consulta3")
    public ModelAndView queryResult3(){
        List<Consulta3Dto> resultList = this.service.getComprasObjetos();
        ModelAndView mv = new ModelAndView("consulta3");
        mv.addObject("resultList", resultList);
        return mv;
    }

    @RequestMapping("/compras/{mes}{ano}")
    public ModelAndView viewPeriodDetails(@PathVariable("mes") int mes, @PathVariable("ano") int ano){
        ModelAndView mv = new ModelAndView("details");
        List<Permanentes> resultList = this.service.getByPeriod(mes,ano);
        mv.addObject("resultList", resultList);
        return mv;
    }

    @RequestMapping("/graficoConsulta3/grafico-mes")
    //Gastos objetos por mes
    public String grafico1Consulta3(Model model){

        List<ObjCompradosPorMesDto> resultList = this.service.getListEmprestadosPorMes();
		Map<String, BigDecimal> consultMap = new LinkedHashMap<>();

        for (ObjCompradosPorMesDto consultaDto : resultList) {

            consultMap.put(consultaDto.getMes(), consultaDto.getCustoTotal());
        }
		
		model.addAttribute("dataMap", consultMap);
		return "graph-spending-month";
    }

    @RequestMapping("/graficoConsulta3/grafico-ano")
    //Gastos objetos por ano
    public String grafico2Consulta3(Model model){

        List<ObjCompradosPorAnoDto> resultList = this.service.getListEmprestadosPorAno();
		Map<String, BigDecimal> consultMap = new LinkedHashMap<>();

        for (ObjCompradosPorAnoDto consultaDto : resultList) {

            consultMap.put(consultaDto.getAno(), consultaDto.getCustoTotal());
        }
		
		model.addAttribute("dataMap", consultMap);
		return "graph-spending-year";
    }

}
