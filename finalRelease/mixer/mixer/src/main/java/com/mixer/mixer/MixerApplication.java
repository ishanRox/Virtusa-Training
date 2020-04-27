package com.mixer.mixer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MixerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MixerApplication.class, args);
	}

}
