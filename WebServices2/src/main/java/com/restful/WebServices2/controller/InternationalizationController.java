package com.restful.WebServices2.controller;

import com.restful.WebServices2.configuration.LocaleConfig;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@Tag(name = "Internationalization controller", description = "greeting in18 controller")
public class InternationalizationController {

    private MessageSource messageSource;


    public InternationalizationController(MessageSource messageSource){
        this.messageSource=messageSource;
    }

    @GetMapping("/hello")
    public String greetingMessage(@RequestParam(value="name",required = true) String userName,
                                    Locale locale){

        return messageSource.getMessage(
                "greeting.message",
                new Object[] {userName} ,
                "Hello User",
                locale
        );
    }
}
