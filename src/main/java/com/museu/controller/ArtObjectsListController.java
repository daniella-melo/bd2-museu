package com.museu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
public class ArtObjectsListController {

    @GetMapping("/objetos")
    public String objetosList() {
        return "objetos-todos";
    }

}