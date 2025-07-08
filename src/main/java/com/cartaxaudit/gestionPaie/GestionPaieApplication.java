package com.cartaxaudit.gestionPaie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class GestionPaieApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionPaieApplication.class, args);
	}

}
