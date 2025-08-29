package com.acme.repository;

import com.acme.model.Speaker;

import java.util.List;

public interface HibernateSpeakerRepo {
    List<Speaker> findAll();

}
