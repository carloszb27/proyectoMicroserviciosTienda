package com.tienda.orquestadortienda.controller;

import com.tienda.orquestadortienda.dtos.ProveedorConsultaDTO;
import com.tienda.orquestadortienda.service.ConsultaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ConsultaController {
    private final ConsultaService consultaService;

    @GetMapping("/consultas/proveedores/{proveedorId}")
    public ResponseEntity<ProveedorConsultaDTO> consultarProveedorPorId(@PathVariable("proveedorId") long proveedorId){
        return new ResponseEntity<>(consultaService.consultarProveedorPorId(proveedorId), HttpStatus.OK);
    }
}