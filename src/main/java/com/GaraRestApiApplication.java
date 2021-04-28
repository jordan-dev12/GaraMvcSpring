package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@ComponentScan({"com.controllore","com.model", "com.repository", "com.service","com.config"})
@SpringBootApplication
public class GaraRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GaraRestApiApplication.class, args);
	}

}
