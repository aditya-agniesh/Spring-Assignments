package com.restful.WebServices2.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.restful.WebServices2.model.FilteredUser;
import com.restful.WebServices2.view.Views;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class FilteredUserController {

    @PostMapping("/static")
    public FilteredUser saveUser(@RequestBody FilteredUser filteredUser){
        return filteredUser;
    }

    // do not show password
    // dynamic filtering
    @PostMapping("/dynamic/view1")
    @JsonView(Views.view1.class)
    public FilteredUser saveUserView1(@RequestBody FilteredUser filteredUser){
        return filteredUser;
    }

    // shows password
    // dynamic filtering
    @PostMapping("/dynamic/view2")
    @JsonView(Views.view2.class)
    public FilteredUser saveUserView2(@RequestBody FilteredUser filteredUser){
        return filteredUser;
    }

}
