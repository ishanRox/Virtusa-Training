package com.ishan.blog.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.security.Key;


@Service
public class JwtProvider {
    private Key key=Keys.secretKeyFor(SignatureAlgorithm.HS512
    );

public String generateToken(Authentication authentication){

  User pUser=(User)authentication.getPrincipal();

 return Jwts.builder().setSubject(pUser.getUsername())
         .signWith
                 (key).compact();
}

public boolean validateTocken(String jwt){
    Jwts.parser().setSigningKey(key).parseClaimsJws(jwt);

    return true;
}

    public String getUsrNameFromJWT(String jwtFromRequest) {
        Claims claims=
                Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(jwtFromRequest)
                .getBody();
        return claims.getSubject();

    }
}
