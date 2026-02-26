package com.example.Hateos.controller;

import com.example.Hateos.model.User;
import com.example.Hateos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public EntityModel<User> getUser(@PathVariable Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        EntityModel<User> resource = EntityModel.of(user);

        // Self link
        resource.add(linkTo(methodOn(UserController.class)
                .getUser(id)).withSelfRel());

        // Link to all topics
        resource.add(linkTo(methodOn(TopicController.class)
                .getAllTopics()).withRel("all-topics"));

        return resource;
    }
}