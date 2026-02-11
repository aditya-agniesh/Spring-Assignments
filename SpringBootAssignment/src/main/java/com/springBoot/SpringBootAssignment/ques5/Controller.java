package com.springBoot.SpringBootAssignment.ques5;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping("/api")
    public String hello(){
        return "Hello Aditya Agniesh";
    }
}
