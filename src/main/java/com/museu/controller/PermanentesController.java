package com.museu.controller;

import java.util.List;

@RequestMapping("/permanentes")
@Controller
public class PermanentesController {

    @Autowired
    private PermanentesService service;

    @RequestMapping("/consulta3")
    public ModelAndView queryResult(){
        List<Consulta1Dto> resultList = this.service.getComprasObjetos();
        ModelAndView mv = new ModelAndView("consulta3");
        mv.addObject("resultList", resultList);
        return mv;
    }
}
