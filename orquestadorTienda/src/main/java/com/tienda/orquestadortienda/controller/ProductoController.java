package com.tienda.orquestadortienda.controller;

import com.tienda.orquestadortienda.dtos.ProductoCreateDTO;
import com.tienda.orquestadortienda.dtos.ProductoDTO;
import com.tienda.orquestadortienda.dtos.ProductoUpdateDTO;
import com.tienda.orquestadortienda.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @GetMapping("/productos/proveedores/{proveedorId}")
    public ResponseEntity<List<ProductoDTO>> listarProductosPorIdProveedor(@PathVariable("proveedorId")  long proveedorId){
        return  new ResponseEntity<>( productoService.listarProductosPorIdProveedor(proveedorId) , HttpStatus.OK);
    }
    @GetMapping("/productos/{productoId}")
    public ResponseEntity<ProductoDTO> obtenerProductoPorID(@PathVariable("productoId") long productoId){
        return  new ResponseEntity<> ( productoService.obtenerProductoPorID(productoId),HttpStatus.OK);
    }
    @PostMapping("productos")
    public ResponseEntity<ProductoDTO> registrarProductos(@RequestBody ProductoCreateDTO productoCreateDTO){
        return  new ResponseEntity <>( productoService.registrarProductos(productoCreateDTO)  ,HttpStatus.OK);
    }
    @PutMapping("productos")
    public ResponseEntity<ProductoDTO> actualizarProductos(@RequestBody ProductoUpdateDTO productoUpdateDTO){
        return new ResponseEntity<>(productoService.actualizarProductos(productoUpdateDTO),HttpStatus.OK);
    }
}
