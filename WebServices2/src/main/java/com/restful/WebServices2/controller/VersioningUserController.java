package com.restful.WebServices2.controller;

import com.restful.WebServices2.model.UserV1;
import com.restful.WebServices2.model.UserV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class VersioningUserController {


    @GetMapping("/v1")
    public UserV1 getUserV1() {
        return new UserV1(1, "Aditya");
    }

    @GetMapping("/v2")
    public UserV2 getUserV2() {
        return new UserV2(1, "Aditya", "aditya@gmail.com", "ADMIN");
    }

    @GetMapping(value = "/param", params = "version=1")
    public UserV1 getUserParamV1() {
        return new UserV1(1, "Aditya");
    }

    @GetMapping(value = "/param", params = "version=2")
    public UserV2 getUserParamV2() {
        return new UserV2(1, "Aditya", "aditya@gmail.com", "ADMIN");
    }

    @GetMapping(value = "/header", headers = "X-API-VERSION=1")
    public UserV1 getUserHeaderV1() {
        return new UserV1(1, "Aditya");
    }

    @GetMapping(value = "/header", headers = "X-API-VERSION=2")
    public UserV2 getUserHeaderV2() {
        return new UserV2(1, "Aditya", "aditya@gmail.com", "ADMIN");
    }

    @GetMapping(value = "/produces",
            produces = "application/vnd.company.app-v1+json")
    public UserV1 getUserMimeV1() {
        return new UserV1(1, "Aditya");
    }

    @GetMapping(value = "/produces",
            produces = "application/vnd.company.app-v2+json")
    public UserV2 getUserMimeV2() {
        return new UserV2(1, "Aditya", "aditya@gmail.com", "ADMIN");
    }


}
