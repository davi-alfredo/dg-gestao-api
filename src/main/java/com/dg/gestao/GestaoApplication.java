package com.dg.gestao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@OpenAPIDefinition(
		  info = @Info(
		  title = "DG Gestão Locadora",
		  description = "" +
		    "Api para fornecer uma interface às informações da DG Locadora",
		  contact = @Contact(
		    name = "David Alfredo dos Santos", 
		    url = "", 
		    email = "davi.alfredo@hotmail.com"
		  )
		)
	)
public class GestaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaoApplication.class, args);
	}

}
