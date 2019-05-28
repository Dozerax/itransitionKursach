package com.itransition.kursach.service;

import com.itransition.kursach.entity.Chapter;
import com.itransition.kursach.entity.Composition;
import com.itransition.kursach.repository.ChapterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChapterService {

    private final ChapterRepository chapterRepository;

    @Autowired
    public ChapterService(ChapterRepository chapterRepository) {
        this.chapterRepository = chapterRepository;
    }

    public Optional<Chapter> findById(Chapter chapter){
        return chapterRepository.findById(chapter.getId());
    }

    public List<Chapter> findChapterByComposition(Composition composition){
        return chapterRepository.findChapterByComposition(composition);
    }

    public void createChapter(String name, String text, Composition composition) {
        Chapter chapter = new Chapter(name,text,composition);
        chapterRepository.save(chapter);
    }

    public void updateChapter(String name, String text,Chapter chapter) {
        chapter.setChaptername(name);
        chapter.setText(text);
        chapterRepository.save(chapter);
    }

    public void deleteChapter(Long id) {
        chapterRepository.deleteById(id);
    }
}
