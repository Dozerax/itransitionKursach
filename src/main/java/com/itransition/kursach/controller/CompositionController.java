package com.itransition.kursach.controller;

import com.itransition.kursach.entity.Composition;
import com.itransition.kursach.entity.Genre;
import com.itransition.kursach.repository.CompositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.Set;

@Controller
public class CompositionController {

    @Autowired
    CompositionRepository compositionRepository;

    @GetMapping("/compositionEditor")
    public String compositionEditorView(Model model){
        model.addAttribute("genres",Genre.values());
        return "compositionEditor";
    }

    @PostMapping("/compositionEditor")
    public String addComposition(
            @RequestParam("textarea") String text,
            @RequestParam("name") String name,
            @RequestParam("checked") Set<Genre> genres
    ){
        Composition composition = new Composition(name,text,genres);
        for (Genre item : genres) {
            System.out.println(item);
        }
        compositionRepository.save(composition);
        return "index";
    }
}
