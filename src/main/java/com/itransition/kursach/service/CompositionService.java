package com.itransition.kursach.service;

import com.itransition.kursach.entity.Composition;
import com.itransition.kursach.entity.Genre;
import com.itransition.kursach.entity.User;
import com.itransition.kursach.repository.CompositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CompositionService {

    private final CompositionRepository compositionRepository;

    @Autowired
    public CompositionService(CompositionRepository compositionRepository) {
        this.compositionRepository = compositionRepository;
    }

    public Page<Composition> findAll(Pageable pageable) {
        return compositionRepository.findAll(pageable);
    }

    public void createComposition(String name, String compositionDescription, String text, Set<Genre> genres, User user) {
        Composition composition = new Composition(name, compositionDescription, text, genres, user.getId(), user.getUsername());
        compositionRepository.save(composition);
    }

    public Page<Composition> findMyComposition(User user,Pageable pageable) {
        return compositionRepository.findCompositionByUserId(user.getId(),pageable);
    }

    public void deleteComposition(Long compositionId) {
        compositionRepository.deleteById(compositionId);
    }

    public void updateComposition(Composition composition, String name, String description, String text, Map<String, String> form) {
        Set<String> genres = Arrays.stream(Genre.values())
                .map(Genre::name).collect(Collectors.toSet());

        composition.getGenres().clear();

        for (String key : form.keySet()) {
            if (genres.contains(key)) {
                composition.getGenres().add(Genre.valueOf(key));
            }
        }

        composition.setCompositionname(name);
        composition.setCompositionDescription(description);
        composition.setText(text);

        compositionRepository.save(composition);
    }

    public Page<Composition> findUserComposition(User user,Pageable pageable) {
        return compositionRepository.findCompositionByUserId(user.getId(),pageable);
    }
}
