package com.fiap.cerveja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class CervejaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CervejaApplication.class, args);
	}

}
