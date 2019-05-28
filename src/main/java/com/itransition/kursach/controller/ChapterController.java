package com.itransition.kursach.controller;

import com.itransition.kursach.entity.Chapter;
import com.itransition.kursach.entity.Composition;
import com.itransition.kursach.repository.ChapterRepository;
import com.itransition.kursach.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChapterController {

    @Autowired
    private ChapterService chapterService;

    @GetMapping("/chapterCreator/{composition}")
    public String chapterCreator(
            Model model,
            @PathVariable Composition composition
    ){
        model.addAttribute("composition",composition.getId().toString());
        return "chapterCreator";
    }

    @PostMapping("/chapterCreator")
    public String chapterCreator(
            @RequestParam("name") String name,
            @RequestParam("textarea") String text,
            @RequestParam("compositionId") Composition composition
    ){
        chapterService.createChapter(name,text,composition);
        return "redirect:/compositionEditor/"+composition.getId();
    }

    @GetMapping("/chapterEditor/{chapter}")
    public String chapterEdit(
            @PathVariable Chapter chapter,
            Model model
    ){
        model.addAttribute("chapter",chapterService.findById(chapter));
        return "chapterEditor";
    }

    @PostMapping("/chapterEditor/{chapter}")
    public String updateChapter(
            @PathVariable Chapter chapter,
            @RequestParam("name") String name,
            @RequestParam("textarea") String text
    ){
        chapterService.updateChapter(name,text,chapter);
        return "redirect:/myComposition";
    }

    @PostMapping("/chapterDelete")
    public String deleteChapter(
            @RequestParam("chapterId") Long id,
            @RequestParam("compositionId") Composition composition
    ){
        chapterService.deleteChapter(id);
        return "redirect:/compositionEditor/"+composition.getId();
    }
}
