package com.itransition.kursach.service;

import com.itransition.kursach.entity.Composition;
import com.itransition.kursach.repository.CompositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;
import java.util.List;

@Service
public class CompositionService {

    @Autowired
    private CompositionRepository compositionRepository;


    public List<Composition> findAll() {
        return compositionRepository.findAll();
    }
}
