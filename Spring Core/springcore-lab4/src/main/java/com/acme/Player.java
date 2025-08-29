package com.acme;

public class Player {
    private String playerId;
    private String playerName;
    private Country country;

    public Player() {}

    public String getPlayerId() {
        return playerId;
    }
    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Country getCountry() {
        return country;
    }
    public void setCountry(Country country) {
        this.country = country;
    }

    public void display() {
        System.out.println("Player Id   : " + playerId);
        System.out.println("Player Name : " + playerName);
        if (country != null) {
            country.display();
        }
        System.out.println();
    }
}
