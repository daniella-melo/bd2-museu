package com.museu.controller;

import com.museu.dtos.Consulta1Dto;
import com.museu.dtos.Consulta2Dto;
import com.museu.model.Permanentes;
import com.museu.service.ObjetosArteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.TypedQuery;
import java.util.List;

@RequestMapping("/objetos")
@Controller
public class ObjetosArteController {

    @Autowired
    private ObjetosArteService service;

    @Autowired
    private Consulta1Dto consulta1Dto;

    @RequestMapping("/consulta1")
    public ModelAndView queryResult1(){
        //List<Consulta1Dto> resultList = this.service.getByTipoEClasse();
        List<Consulta1Dto> resultList = this.service.getConsulta1();
        ModelAndView mv = new ModelAndView("consulta1");
        mv.addObject("resultList", resultList);
        return mv;
    }
}
