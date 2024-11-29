package com.proyectodswii.clientestienda.controller;

import com.proyectodswii.clientestienda.dtos.ClienteCreateDTO;
import com.proyectodswii.clientestienda.dtos.ClienteDTO;
import com.proyectodswii.clientestienda.dtos.ClienteUpdateDTO;
import com.proyectodswii.clientestienda.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping("/clientes/proveedores/{proveedorId}")
    public ResponseEntity<List<ClienteDTO>> listarClientePorIdProveedor(@PathVariable("proveedorId") long proveedorId){
        return   new ResponseEntity<>(clienteService.listarClientePorIdProveedor(proveedorId) , HttpStatus.OK);
    }
    @GetMapping("/clientes/{clienteId}")
    public ResponseEntity<ClienteDTO> obtenerClientePorId(@PathVariable("clienteId") long clienteId){
        return  new ResponseEntity<> ( clienteService.obtenerClientePorID(clienteId),HttpStatus.OK);
    }

    @PostMapping("clientes")
    public ResponseEntity<ClienteDTO> registrarCliente(@RequestBody ClienteCreateDTO clienteCreateDTO){
        return  new ResponseEntity <>( clienteService.registrarCliente(clienteCreateDTO) ,HttpStatus.OK);
    }

    @PutMapping("clientes")
    public ResponseEntity<ClienteDTO> actualizarCliente(@RequestBody ClienteUpdateDTO clienteUpdateDTO){
        return new ResponseEntity<>(clienteService.actualizarCliente(clienteUpdateDTO),HttpStatus.OK);
    }

    @DeleteMapping("/clientes/{clienteId}")
    public ResponseEntity<String> eliminarCliente(@PathVariable("clienteId") long clienteId) {
        return new ResponseEntity<>( clienteService.eliminarCliente(clienteId),HttpStatus.OK);
    }

}
