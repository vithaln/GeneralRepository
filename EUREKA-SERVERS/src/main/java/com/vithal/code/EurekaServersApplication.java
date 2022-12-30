package com.vithal.code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServersApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServersApplication.class, args);
	}

}
