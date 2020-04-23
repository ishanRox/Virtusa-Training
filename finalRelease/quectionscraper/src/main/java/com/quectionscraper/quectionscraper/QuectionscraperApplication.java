package com.quectionscraper.quectionscraper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class QuectionscraperApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuectionscraperApplication.class, args);
	}

}
