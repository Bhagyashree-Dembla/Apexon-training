package com.acme;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context =
                     new ClassPathXmlApplicationContext("playerBean.xml")) {

            // get all players
            List<Player> players = Arrays.asList(
                    context.getBean("player1", Player.class),
                    context.getBean("player2", Player.class),
                    context.getBean("player3", Player.class),
                    context.getBean("player4", Player.class),
                    context.getBean("player5", Player.class)
            );

            System.out.println("---- All Players ----");
            for (Player p : players) {
                p.display();
            }

            // Search players by country name
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter country name to list players: ");
            String searchCountry = sc.nextLine();

            System.out.println("Players from " + searchCountry + ":");
            for (Player p : players) {
                if (p.getCountry().getCountryName().equalsIgnoreCase(searchCountry)) {
                    System.out.println(" - " + p.getPlayerName());
                }
            }
        }
    }
}