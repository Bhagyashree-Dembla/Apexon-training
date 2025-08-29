package com.acme;

import com.acme.service.SpeakerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Application {
    public static void main(String[] args) {
//        SpeakerService service = new SpeakerServiceImpl();
//        System.out.println(service.findAll().get(0).getFirstName());
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        SpeakerService service = applicationContext.getBean("speakerService", SpeakerService.class);
        System.out.println(service.findAll().get(0).getFirstName());
    }
}