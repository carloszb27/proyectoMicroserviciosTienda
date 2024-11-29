package com.tienda.orquestadortienda.controller;

import com.tienda.orquestadortienda.dtos.ProveedorCreateDTO;
import com.tienda.orquestadortienda.dtos.ProveedorDTO;
import com.tienda.orquestadortienda.dtos.ProveedorUpdateDTO;
import com.tienda.orquestadortienda.service.ProveedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProveedorController {

    private final ProveedorService proveedorService;

    @GetMapping("proveedores")
    public ResponseEntity<List<ProveedorDTO>> listarProveedores(){
        return new ResponseEntity<>(proveedorService.listarProveedor(), HttpStatus.OK);
    }

    @GetMapping("proveedores/{proveedorId}")
    public ResponseEntity<ProveedorDTO> obtenerProveedorPorId(@PathVariable("proveedorId") long proveedorId){
        return new ResponseEntity<>( proveedorService.obtenerProveedorPorID(proveedorId),HttpStatus.OK);
    }

    @PostMapping("proveedores")
    public ResponseEntity<ProveedorDTO> registrarProveedor(@RequestBody ProveedorCreateDTO proveedorCreateDTO){
        return new ResponseEntity<>(proveedorService.registrarProveedor(proveedorCreateDTO),HttpStatus.OK);
    }

    @PutMapping("proveedores")
    public ResponseEntity<ProveedorDTO> actualizarProveedor(@RequestBody ProveedorUpdateDTO proveedorUpdateDTO){
        return new ResponseEntity<>(proveedorService.actualizarProveedor(proveedorUpdateDTO),HttpStatus.OK);
    }
}
