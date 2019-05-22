package com.itransition.kursach.controller;

import com.itransition.kursach.repository.CompositionRepository;
import com.itransition.kursach.service.CompositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    CompositionRepository compositionRepository;

    @Autowired
    CompositionService compositionService;

    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("compositions",compositionService.findAll());
        return "index";
    }
}