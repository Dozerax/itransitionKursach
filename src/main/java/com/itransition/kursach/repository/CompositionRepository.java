package com.itransition.kursach.repository;

import com.itransition.kursach.entity.Composition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CompositionRepository extends JpaRepository <Composition,Long> {
    Composition findByCompositionname(String comositionname);

    Page<Composition> findAll(Pageable pageable);

    Page<Composition> findCompositionByUserId(Long userId, Pageable pageable);

    List<Composition> findCompositionByUserId(Long userId);

}