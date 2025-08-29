package com.acme;

import com.acme.model.Speaker;
import com.acme.service.SpeakerService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(AppConfig.class)) {

            SpeakerService speakerService = context.getBean("speakerService", SpeakerService.class);

            List<Speaker> speakers = speakerService.findAll();

            System.out.println("Speakers found:");
            speakers.forEach(System.out::println);
        }
    }
}