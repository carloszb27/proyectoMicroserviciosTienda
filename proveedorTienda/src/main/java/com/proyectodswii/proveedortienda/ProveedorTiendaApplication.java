package com.proyectodswii.proveedortienda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ProveedorTiendaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProveedorTiendaApplication.class, args);
	}

}
