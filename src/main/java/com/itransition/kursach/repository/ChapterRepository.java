package com.itransition.kursach.repository;

import com.itransition.kursach.entity.Chapter;
import com.itransition.kursach.entity.Composition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChapterRepository extends JpaRepository<Chapter,Long> {
    List<Chapter> findChapterByComposition(Composition composition);
}
