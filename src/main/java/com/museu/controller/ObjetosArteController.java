package com.museu.controller;

import com.museu.dtos.Consulta1Dto;
import com.museu.service.ObjetosArteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/consulta1")
@Controller
public class ObjetosArteController {

    @Autowired
    private ObjetosArteService service;

    @RequestMapping("/")
    public ModelAndView queryResult(){
        List<Consulta1Dto> resultList = this.service.getByTipoEClasse();
        ModelAndView mv = new ModelAndView("consulta1");
        mv.addObject("resultList", resultList);
    }
}
