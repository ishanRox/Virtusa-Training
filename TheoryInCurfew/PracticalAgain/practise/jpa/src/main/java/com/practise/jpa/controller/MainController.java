package com.practise.jpa.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @RequestMapping(value = "/hello"method= RequestMethod.GET)
    public String greeting() {
        return "hello springboot";
    }

}
