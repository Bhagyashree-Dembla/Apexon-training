package com.acme;
import com.acme.repository.HibernateSpeakerRepo;
import com.acme.repository.HibernateSpeakerRepoImpl;
import com.acme.service.SpeakerService;
import com.acme.service.SpeakerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(name = "speakerRepo")
    public HibernateSpeakerRepo getSpeakerRepo() {
        return new HibernateSpeakerRepoImpl();
    }

    @Bean(name = "speakerService")
    public SpeakerService getSpeakerService() {
        return new SpeakerServiceImpl(getSpeakerRepo());
    }
}
