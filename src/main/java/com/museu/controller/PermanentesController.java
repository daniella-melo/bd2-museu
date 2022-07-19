package com.museu.controller;

import com.museu.dtos.Consulta2Dto;
import com.museu.dtos.Consulta3Dto;
import com.museu.model.Permanentes;
import com.museu.service.PermanentesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/permanentes")
@Controller
public class PermanentesController {

    @Autowired
    private PermanentesService service;

    @Autowired
    private Consulta3Dto consulta3Dto;

    // @Bean
    // @RequestMapping("/consulta3")
    // public ModelAndView queryResult3(){
    //     List<Consulta3Dto> resultList = this.service.getComprasObjetos();
    //     ModelAndView mv = new ModelAndView("consulta3");
    //     mv.addObject("resultList", resultList);
    //     return mv;
    // }

    @RequestMapping("/compras/{mes}{ano}")
    public ModelAndView viewPeriodDetails(@PathVariable("mes") int mes, @PathVariable("ano") int ano){
        ModelAndView mv = new ModelAndView("details");
        List<Permanentes> resultList = this.service.getByPeriod(mes,ano);
        mv.addObject("resultList", resultList);
        return mv;
    }
}
