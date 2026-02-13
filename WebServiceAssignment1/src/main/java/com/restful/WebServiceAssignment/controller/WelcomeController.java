package com.restful.WebServiceAssignment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/welcome")
    public String displayMessage(){
        return "Welcome to Spring Boot";
    }
}
