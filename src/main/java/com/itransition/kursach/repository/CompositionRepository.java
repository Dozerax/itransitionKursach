package com.itransition.kursach.repository;

import com.itransition.kursach.entity.Composition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompositionRepository extends JpaRepository <Composition,Long> {
    Composition findByCompositionname(String comositionname);

    List<Composition> findCompositionByUserId(Long userId);
}