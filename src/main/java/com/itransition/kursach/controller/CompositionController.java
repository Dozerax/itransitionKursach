package com.itransition.kursach.controller;


import com.itransition.kursach.entity.Composition;
import com.itransition.kursach.entity.Genre;
import com.itransition.kursach.entity.User;
import com.itransition.kursach.service.ChapterService;
import com.itransition.kursach.service.CompositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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

    private final CompositionService compositionService;

    final
    ChapterService chapterService;

    @Autowired
    public CompositionController(CompositionService compositionService, ChapterService chapterService) {
        this.compositionService = compositionService;
        this.chapterService = chapterService;
    }

    @GetMapping("/allComposition")
    public String allComposition(
            Model model,
            @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable
    ){
        Page<Composition> page = compositionService.findAll(pageable);
        model.addAttribute("compositions",page);
        model.addAttribute("url", "/allComposition");
        return "allComposition";
    }

    @GetMapping("/compositionCreate")
    public String compositionEditorView(Model model){
        model.addAttribute("genres",Genre.values());
        return "compositionCreator";
    }

    @PostMapping("/compositionCreate")
    public String addComposition(
            @RequestParam("description") String description,
            @RequestParam("name") String name,
            @RequestParam("checked") Set<Genre> genres,
            @AuthenticationPrincipal User user
    ){
        Composition composition = compositionService.createComposition(name,description,genres,user);
        return "redirect:/chapterCreator/"+composition.getId().toString();
    }

    @GetMapping("/myComposition")
    public String getMyComposition(
            Model model,
            @AuthenticationPrincipal User user,
            @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable
    ){
        Page<Composition> page = compositionService.findMyComposition(user,pageable);
        model.addAttribute("compositions",page);
        model.addAttribute("url", "/myComposition");
        return "myComposition";
    }

    @GetMapping("/userComposition/{user}")
    public String getUserComposition(
            Model model,
            @PathVariable User user,
            @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable
    ){
        Page<Composition> page = compositionService.findUserComposition(user,pageable);
        model.addAttribute("compositions",page);
        model.addAttribute("url", "/userComposition/{user}/");
        return "userComposition";
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
        model.addAttribute("chapters",chapterService.findChapterByComposition(composition));
        model.addAttribute("composition",composition);
        return "compositionEditor";
    }

    @GetMapping("/compositionReader/{composition}")
    public String read(
            @PathVariable Composition composition,
            Model model
    ){
        model.addAttribute("chapters",chapterService.findChapterByComposition(composition));
        model.addAttribute("composition",composition);
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
