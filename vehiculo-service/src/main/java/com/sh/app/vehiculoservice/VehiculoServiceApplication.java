package com.sh.app.vehiculoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class VehiculoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehiculoServiceApplication.class, args);
	}

}
