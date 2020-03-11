package com.ishan.blog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        String jwtFromRequest = getJwtFromRequest(httpServletRequest);

        if (StringUtils.hasText(jwtFromRequest)
                && jwtProvider.validateTocken(jwtFromRequest)
        ) {

            String usrNameFromJWT = jwtProvider.getUsrNameFromJWT(jwtFromRequest);

            UserDetails userDetails =
                    userDetailsService
                            .loadUserByUsername(usrNameFromJWT);
            UsernamePasswordAuthenticationToken
                    token = new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities()

            );

            token.setDetails(new WebAuthenticationDetailsSource()
            .buildDetails(httpServletRequest));

            SecurityContextHolder.getContext()
            .setAuthentication(token);
        }

        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }

    private String getJwtFromRequest(HttpServletRequest httpServletRequest) {

        String bearerTocken
                =
                httpServletRequest
                        .getHeader("Authorization");
        if (StringUtils.hasLength(bearerTocken)
                &&
                bearerTocken.startsWith("Bearer")
        ) {
            return bearerTocken.substring('?');
        }
        return bearerTocken;
    }
}
