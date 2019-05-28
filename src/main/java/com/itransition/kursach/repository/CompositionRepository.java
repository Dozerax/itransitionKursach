package com.itransition.kursach.repository;

import com.itransition.kursach.entity.Composition;
import com.itransition.kursach.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CompositionRepository extends JpaRepository <Composition,Long> {
    Composition findByCompositionname(String comositionname);

    Page<Composition> findAll(Pageable pageable);

    Page<Composition> findCompositionByAuthor(User author, Pageable pageable);

    List<Composition> findCompositionByAuthor(User author);
}