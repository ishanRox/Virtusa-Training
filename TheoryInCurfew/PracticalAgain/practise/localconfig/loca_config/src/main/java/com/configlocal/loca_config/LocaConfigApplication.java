package com.configlocal.loca_config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class LocaConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocaConfigApplication.class, args);
	}

}
