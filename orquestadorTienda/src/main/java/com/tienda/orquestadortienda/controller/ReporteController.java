package com.tienda.orquestadortienda.controller;

import com.tienda.orquestadortienda.service.ReporteService;
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
public class ReporteController {

    private final ReporteService reporteService;

    @GetMapping("/reportes/proveedores/{proveedorId}")
    public ResponseEntity<String> obtenerReportePorProveedorId(@PathVariable("proveedorId") long proveedorId){
        return new ResponseEntity<>(reporteService.obtenerReportePorProveedorId(proveedorId), HttpStatus.OK);
    }

}
