package com.proyectodswii.proveedortienda.controller;

import com.proyectodswii.proveedortienda.dtos.ProveedorCreateDTO;
import com.proyectodswii.proveedortienda.dtos.ProveedorDTO;
import com.proyectodswii.proveedortienda.dtos.ProveedorUpdateDTO;
import com.proyectodswii.proveedortienda.service.ProveedorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
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

    @DeleteMapping("proveedores/{proveedorId}")
    public ResponseEntity<String> eliminarProveedor(@PathVariable("proveedorId") long proveedorId) {
        return new ResponseEntity<>(proveedorService.eliminarProveedor(proveedorId), HttpStatus.OK);
    }
    
}
