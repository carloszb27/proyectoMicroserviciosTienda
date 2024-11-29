package com.proyectodswii.proveedortienda.feignClient;

import com.proyectodswii.proveedortienda.config.FeignClientConfig;
import com.proyectodswii.proveedortienda.dtos.ClienteCreateDTO;
import com.proyectodswii.proveedortienda.dtos.ClienteUpdateDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name="cliente-api", url="http://localhost:8082/api", configuration = FeignClientConfig.class)
public interface ClienteFeignClient {

    @PostMapping("/clientes")
    ClienteCreateDTO registrarCliente(ClienteCreateDTO clienteCreateDTO);

    @PutMapping("/clientes")
    ClienteUpdateDTO actualizarCliente(ClienteUpdateDTO clienteUpdateDTO);
}
