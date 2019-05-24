package com.itransition.kursach.controller;

import com.itransition.kursach.entity.Composition;
import com.itransition.kursach.entity.Genre;
import com.itransition.kursach.service.CompositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class MainController {

    private final CompositionService compositionService;

    @Autowired
    public MainController(CompositionService compositionService) {
        this.compositionService = compositionService;
    }

    @GetMapping("/")
    public String main(
            Model model,
            @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable
    ) {
        Page<Composition> page = compositionService.findAll(pageable);
        model.addAttribute("compositions", page);
        model.addAttribute("url", "/");
        model.addAttribute("genres", Genre.values());
        return "index";
    }
}