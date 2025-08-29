package com.acme.repository;

import com.acme.model.Speaker;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public class HibernateSpeakerRepoImpl implements HibernateSpeakerRepo {



    @Override
    public List<Speaker> findAll(){
        List<Speaker> result = new ArrayList<>();
        Speaker s = new Speaker("John","Doe");
        result.add(s);
        result.add(new Speaker("Lakshmi", "Manasa"));

        return result;
    }

}
