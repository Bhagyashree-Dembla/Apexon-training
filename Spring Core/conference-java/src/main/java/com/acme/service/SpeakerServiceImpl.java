package com.acme.service;

import com.acme.model.Speaker;
import com.acme.repository.HibernateSpeakerRepo;

import java.util.List;

public class SpeakerServiceImpl implements SpeakerService {

    private HibernateSpeakerRepo speakerRepo;

    // Constructor injection
    public SpeakerServiceImpl(HibernateSpeakerRepo speakerRepo) {
        this.speakerRepo = speakerRepo;
    }

    @Override
    public List<Speaker> findAll() {
        return speakerRepo.findAll();
    }
}
