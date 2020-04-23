package com.angular.ishan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


import java.util.stream.Stream;

@SpringBootApplication
@EnableEurekaClient
public class IshanApplication {

	public static void main(String[] args) {
		SpringApplication.run(IshanApplication.class, args);
	}

   }

