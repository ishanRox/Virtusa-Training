package com.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//handle cors for our angular
@RestController
public class Controller {


  @GetMapping("hello")
  public String hello(){

    return "helooooooo";
  }

}
