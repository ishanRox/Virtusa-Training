package com.ishan.blog.service;

import com.ishan.blog.dto.LoginRequest;
import com.ishan.blog.dto.RegisterRequest;
import com.ishan.blog.model.User;
import com.ishan.blog.repository.UserRepository;
import com.ishan.blog.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private JwtProvider jwtProvider;

  public void signUp(RegisterRequest registerRequest) {

    User user = new User();
    user.setUserName(registerRequest.getUsername());
    user.setPassword(encodePassword(registerRequest.getPassword()));
    user.setEmail(registerRequest.getEmail());

    userRepository.save(user);

  }

  private String encodePassword(String password) {

    return passwordEncoder.encode(password);
  }

  public String login(LoginRequest loginRequest) {
    Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authenticate);

    return jwtProvider.generateToken(authenticate);
  }
}
