package com.acme;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context =
                     new ClassPathXmlApplicationContext("studentBean.xml")) {

            Student student1 = context.getBean("student1", Student.class);
            Student student2 = context.getBean("student2", Student.class);

            System.out.println("---- Student 1 ----");
            student1.display();

            System.out.println("---- Student 2 ----");
            student2.display();
        }
    }
}