package com.rafael.gerenciador.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class NovoGerenciadorDeGastosApplication {

	public static void main(String[] args) {
		SpringApplication.run(NovoGerenciadorDeGastosApplication.class, args);
	}

}
