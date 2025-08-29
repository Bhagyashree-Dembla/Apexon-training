package com.acme.service;

import com.acme.model.Speaker;
import com.acme.repository.HibernateSpeakerRepositoryImpl;
import com.acme.repository.SpeakerRepository;
import jakarta.annotation.PostConstruct;

import java.util.List;

public class SpeakerServiceImpl implements SpeakerService {

    private SpeakerRepository repository;

    public SpeakerServiceImpl() {
        System.out.println("In no arg constructor");
    }

    public SpeakerServiceImpl(SpeakerRepository repository) {
        System.out.println("In all arg constructor");
        this.repository = repository;
    }

    @PostConstruct
    private void initialize() {
        System.out.println("We're called after the constructor");
    }
    public void setRepository(SpeakerRepository repository) {
        System.out.println("Inside setter");
        this.repository = repository;
    }

    @Override
    public List<Speaker> findAll() {
        return repository.findAll();
    }
}
