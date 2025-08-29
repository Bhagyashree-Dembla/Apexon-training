package com.acme.repository;

import java.util.ArrayList;
import java.util.List;
import com.acme.model.Speaker;

public class HibernateSpeakerRepoImpl implements HibernateSpeakerRepo {

    @Override
    public List<Speaker> findAll() {
        List<Speaker> result = new ArrayList<>();
        result.add(new Speaker("John", "Doe"));
        result.add(new Speaker("Alice", "Cruise"));
        return result;
    }
}
