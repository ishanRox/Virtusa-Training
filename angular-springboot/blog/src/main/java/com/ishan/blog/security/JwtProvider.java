package com.ishan.blog.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;


@Service
public class JwtProvider {
public String generateToken(Authentication authentication){

  User pUser=(User)authentication.getPrincipal();

 return Jwts.builder().setSubject(pUser.getUsername())
         .signWith(Keys.secretKeyFor(SignatureAlgorithm.HS512
         )).compact();
}
}
