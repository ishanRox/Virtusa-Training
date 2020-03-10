package com.ishan.blog.security;

import com.ishan.blog.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;


@Service
public class JwtProvider {
public String generateToken(Authentication authentication){

  User pUser=(User)authentication.getPrincipal();

 return Jwts.builder().setSubject(pUser.getUserName())
         .signWith(SignatureAlgorithm.HS512
         ).compact();
}
}
