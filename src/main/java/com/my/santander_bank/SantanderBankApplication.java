package com.my.santander_bank;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.servers.Servers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// `@OpenAPIDefinition` -> Anotação usada para definir a configuração da API OpenAPI.
// `@Server` -> Define um servidor para a API, incluindo a URL base e uma descrição.
// url = "/" -> Define a URL base do servidor como a raiz do aplicativo.
// description = "Santander Bank API" -> Fornece uma descrição do servidor, que pode ser útil para documentação e entendimento da API.
@OpenAPIDefinition(servers = {@Server(url = "/", description = "Default Server URL")})
@SpringBootApplication
public class SantanderBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(SantanderBankApplication.class, args);
	}

}
