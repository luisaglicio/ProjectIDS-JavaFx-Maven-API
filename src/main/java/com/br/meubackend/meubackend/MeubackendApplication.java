package com.br.meubackend.meubackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan ( basePackages = { "com.br.meubackend.meubackend.controller" })
public class MeubackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeubackendApplication.class, args);
	}

}
