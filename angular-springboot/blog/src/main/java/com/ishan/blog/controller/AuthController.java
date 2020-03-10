package com.ishan.blog.controller;

import com.ishan.blog.dto.LoginRequest;
import com.ishan.blog.dto.RegisterRequest;
import com.ishan.blog.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

  @Autowired
  AuthService authService;

  @PostMapping("/signup")
  public ResponseEntity signUp(@RequestBody RegisterRequest registerRequest){
    authService.signUp(registerRequest);
  return new ResponseEntity(HttpStatus.OK);
  }

  @PostMapping("/login")
  public ResponseEntity login(@RequestBody LoginRequest loginRequest){
    authService.login(loginRequest);
    return new ResponseEntity(HttpStatus.OK);
  }

}
