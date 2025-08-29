package com.acme.service;

import com.acme.model.Speaker;
import com.acme.repository.HibernateSpeakerRepo;
import com.acme.repository.HibernateSpeakerRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

public class SpeakerServiceImpl implements SpeakerService {

    private HibernateSpeakerRepo speakerRepo;

    @Override
    public List<Speaker> findAll(){
        return speakerRepo.findAll();
    }

}
