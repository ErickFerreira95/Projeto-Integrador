package com.senac.ProjetoIntegrador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.senac.ProjetoIntegrador")
public class ProjetoIntegradorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoIntegradorApplication.class, args);
	}

}
