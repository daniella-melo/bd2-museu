package com.museu.controller;

import com.museu.service.ColecaoService;
import com.museu.dtos.Consulta2Dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/colecao")
public class ColecaoController {

    @Autowired
    private ColecaoService service;

    @Autowired
    private Consulta2Dto consulta2Dto;

    // @Bean
    // @RequestMapping("/consulta2")
    // public ModelAndView queryResult2(){
    //     ModelAndView mv = new ModelAndView("consulta2");
    //     List<Consulta2Dto> resultList = this.service.getConsulta2();
    //     mv.addObject("resultList", resultList);
    //     return mv;
    // }
}
