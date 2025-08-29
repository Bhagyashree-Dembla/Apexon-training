package com.acme;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context =
                     new ClassPathXmlApplicationContext("applicationContext.xml")) {
            Movie movie = context.getBean("movieBean", Movie.class);
            movie.display();
            DefaultMessage msg = context.getBean("defaultMessageBean", DefaultMessage.class);
            msg.display();
            msg.setMessage("Spring core!");
            msg.display();
        }
    }
}