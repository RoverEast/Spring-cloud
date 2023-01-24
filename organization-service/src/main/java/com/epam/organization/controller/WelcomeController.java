package com.epam.organization.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @Value("${welcome.value}")
    private String welcome;

    @GetMapping("/welcome")
    public String welcome(){
        return "Running on version: " + welcome;
    }

}
