package com.tienda.orquestadortienda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class OrquestadorTiendaApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrquestadorTiendaApplication.class, args);
	}

}
