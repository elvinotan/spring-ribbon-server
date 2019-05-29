package com.elvino.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringRibbonServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRibbonServerApplication.class, args);
	}

}
