package com.museu.controller;

import com.museu.dtos.Consulta1Dto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String home() {
        return "home";
    }
<<<<<<< HEAD

=======
>>>>>>> cf6d29a4fa3112e5243abba5cdfc6a0bb14e339c
}