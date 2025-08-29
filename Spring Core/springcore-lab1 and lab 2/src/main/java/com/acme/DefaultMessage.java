package com.acme;

public class DefaultMessage {
    private String message = "Spring";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void display() {
        System.out.println("Message: " + message);
    }
}
