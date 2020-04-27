package com.angular.ishan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class simple_quection_answer_server {

	public static void main(String[] args) {
		SpringApplication.run(simple_quection_answer_server.class, args);
	}

   }

