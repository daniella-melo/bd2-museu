package com.museu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.ui.Model;

import java.util.List;

@Controller
public class ReportsController {

    @RequestMapping(value = "/reports/",method = RequestMethod.GET)
	public String barGraph(Model model) {
		Map<String, Integer> surveyMap = new LinkedHashMap<>();
		surveyMap.put("Janeiro", 40);
		surveyMap.put("Fevereiro", 25);
		surveyMap.put("Março", 20);
		surveyMap.put("Abril", 15);
		surveyMap.put("Maio", 15);
		surveyMap.put("Junho", 15);
		surveyMap.put("Julho", 15);
		surveyMap.put("Agosto", 15);
		surveyMap.put("Setembro", 15);
		surveyMap.put("Outubro", 15);
		surveyMap.put("Novembro", 15);
		surveyMap.put("Dezembro", 15);
		model.addAttribute("surveyMap", surveyMap);
		return "graph-spending-month";
	}
}
