package com.tienda.orquestadortienda.feignClient;

import com.tienda.orquestadortienda.dtos.ClienteCreateDTO;
import com.tienda.orquestadortienda.dtos.ClienteDTO;
import com.tienda.orquestadortienda.dtos.ClienteUpdateDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="cliente-api", url ="http://localhost:8082/api")
public interface ClienteFeignClient {

    @GetMapping("/clientes/proveedores/{proveedorId}")
    List<ClienteDTO> listarClientePorIdProveedor(@PathVariable("proveedorId") long proveedorId);

    @GetMapping("/clientes/{clienteId}")
    ClienteDTO obtenerClientePorId(@PathVariable("clienteId") long clienteId);
    @PostMapping("/clientes")
    ClienteDTO registrarCliente(@RequestBody ClienteCreateDTO clienteCreateDTO);

    @PutMapping("/clientes")
    ClienteDTO actualizarCliente(@RequestBody ClienteUpdateDTO clienteUpdateDTO);
    /*
    @DeleteMapping("/clientes/{clienteId}")
    String eliminarCliente(@PathVariable("clienteId") long clienteId);
    */

}
