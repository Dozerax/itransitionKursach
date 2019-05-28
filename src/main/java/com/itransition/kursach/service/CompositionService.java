package com.itransition.kursach.service;

import com.itransition.kursach.entity.Chapter;
import com.itransition.kursach.entity.Composition;
import com.itransition.kursach.entity.Genre;
import com.itransition.kursach.entity.User;
import com.itransition.kursach.repository.CompositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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

    public Composition createComposition(String name, String compositionDescription, Set<Genre> genres, User user) {
        Composition composition = new Composition(name,compositionDescription,genres,user);
        compositionRepository.save(composition);
        return composition;
    }

    public Page<Composition> findMyComposition(User user,Pageable pageable) {
        return compositionRepository.findCompositionByAuthor(user,pageable);
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

        compositionRepository.save(composition);
    }

    public Page<Composition> findUserComposition(User user,Pageable pageable) {
        return compositionRepository.findCompositionByAuthor(user,pageable);
    }
}
