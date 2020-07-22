package com.rentCloudAuth.authserver.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
public class AuthServerConfiguration extends WebSecurityConfigurerAdapter implements AuthorizationServerConfigurer {

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {

    }

    @Override
    public void configure(ClientDetailsServiceConfigurer client) throws Exception {

    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoint) throws Exception {

    }
}
