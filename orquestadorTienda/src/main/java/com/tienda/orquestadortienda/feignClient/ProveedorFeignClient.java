package com.tienda.orquestadortienda.feignClient;

import com.tienda.orquestadortienda.dtos.ProveedorCreateDTO;
import com.tienda.orquestadortienda.dtos.ProveedorDTO;
import com.tienda.orquestadortienda.dtos.ProveedorUpdateDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@FeignClient(name="proveedores-api", url ="http://localhost:8081/api")
public interface ProveedorFeignClient {

    @GetMapping("/proveedores")
    List<ProveedorDTO> listarProveedores();

    @GetMapping("/proveedores/{proveedorId}")
    ProveedorDTO obtenerProveedorPorId(@PathVariable("proveedorId") long proveedorId);

    @PostMapping("/proveedores")
    ProveedorDTO registrarProveedor(ProveedorCreateDTO proveedorCreateDTO);

    @PutMapping("/proveedores")
    ProveedorDTO actualizarProveedor(ProveedorUpdateDTO proveedorUpdateDTO);
}
