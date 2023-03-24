package com.example.demo.Utils;
public class GreetingService {
    private String message;
    private String target;

    public GreetingService(String message, String target) {
        this.message = message;
        this.target = target;
    }

    public String greet() {
        return message + " " + target;
    }
}
