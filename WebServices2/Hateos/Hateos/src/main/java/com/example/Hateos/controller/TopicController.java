package com.example.Hateos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @GetMapping
    public List<String> getAllTopics() {
        return List.of("Java", "Spring Boot", "Hibernate");
    }
}