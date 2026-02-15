package com.restful.WebServices2.controller;

import com.restful.WebServices2.model.UsersXml;
import com.restful.WebServices2.services.UserXmlService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Tag(name = "User Xml Controller", description = "Handles all operations related to user xmls")
public class UserControllerXml {

    private UserXmlService userXmlService;

    public UserControllerXml(UserXmlService userXmlService){
        this.userXmlService = userXmlService;
    }

    @GetMapping(value = "/show",
                produces = "application/xml")
    public List<UsersXml> showUser(){
        return userXmlService.getAllUser();
    }

    @PostMapping(value = "/add",
                produces = "text/plain",   // we are returning string and not exposing our data by returning it
                consumes = "application/xml")
    public ResponseEntity<String> user(@RequestBody UsersXml usersXml){
        userXmlService.addUser(usersXml);
        return new ResponseEntity<>("User added successfully", HttpStatus.CREATED);
    }

}
