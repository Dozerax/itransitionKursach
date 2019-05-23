package com.itransition.kursach.controller;

import com.itransition.kursach.entity.Composition;
import com.itransition.kursach.entity.Genre;
import com.itransition.kursach.entity.User;
import com.itransition.kursach.repository.CompositionRepository;
import com.itransition.kursach.service.CompositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Set;

@Controller
public class CompositionController {

    @Autowired
    CompositionRepository compositionRepository;

    @Autowired
    CompositionService compositionService;

    @GetMapping("/allComposition")
    public String allComposition(Model model){
        model.addAttribute("compositions",compositionService.findAll());
        return "allComposition";
    }

    @GetMapping("/compositionCreate")
    public String compositionEditorView(Model model){
        model.addAttribute("genres",Genre.values());
        return "compositionCreate";
    }

    @PostMapping("/compositionCreate")
    public String addComposition(
            @RequestParam("textarea") String text,
            @RequestParam("description") String description,
            @RequestParam("name") String name,
            @RequestParam("checked") Set<Genre> genres,
            @AuthenticationPrincipal User user
    ){
        compositionService.createComposition(name,description,text,genres,user);
        return "redirect:/";
    }

    @GetMapping("/myComposition")
    public String getMyComposition(
            Model model,
            @AuthenticationPrincipal User user
    ){
        model.addAttribute("myComposition",compositionService.findMyComposition(user));
        return "myComposition";
    }

    @PostMapping("/myComposition/delete")
    public String deleteComposition(
            @RequestParam("compositionId") Long compositionId
    ){
        compositionService.deleteComposition(compositionId);
        return "redirect:/myComposition";
    }

    @GetMapping("/compositionEditor/{composition}")
    public String editFormComposition(
            @PathVariable Composition composition,
            Model model
    ){
        model.addAttribute("composition",composition);
        model.addAttribute("genres",Genre.values());
        return "compositionEditor";
    }

    @GetMapping("/compositionReader/{composition}")
    public String read(
            @PathVariable Composition composition,
            Model model
    ){
        model.addAttribute("composition",composition);
        model.addAttribute("genres",Genre.values());
        return "compositionReader";
    }

    @PostMapping("/myComposition/update")
    public String updateComposition(
            @RequestParam("compositionId") Composition composition,
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("textarea") String text,
            @RequestParam Map<String, String> form
    ){
        compositionService.updateComposition(composition,name,description,text,form);
        return "redirect:/myComposition";
    }
}
