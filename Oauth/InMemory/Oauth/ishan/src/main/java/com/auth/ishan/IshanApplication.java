package com.auth.ishan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableAuthorizationServer
public class IshanApplication {

	public static void main(String[] args) {
		SpringApplication.run(IshanApplication.class, args);
	}

}
