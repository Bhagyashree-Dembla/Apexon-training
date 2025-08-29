package com.acme;

import com.acme.model.Speaker;
import com.acme.service.SpeakerService;
import com.acme.service.SpeakerServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

       SpeakerService service = new SpeakerServiceImpl();

        System.out.println(service.findAll());

    }
}
