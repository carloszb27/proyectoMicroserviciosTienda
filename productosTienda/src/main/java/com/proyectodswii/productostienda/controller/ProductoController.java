package com.proyectodswii.productostienda.controller;

import com.proyectodswii.productostienda.dtos.ProductoCreateDTO;
import com.proyectodswii.productostienda.dtos.ProductoDTO;
import com.proyectodswii.productostienda.dtos.ProductoUpdateDTO;
import com.proyectodswii.productostienda.service.ProductoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@AllArgsConstructor
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
    @DeleteMapping("/productos/{productoId}")
    public ResponseEntity<String> eliminarProductos(@PathVariable("productoId") long productoId) {
        return new ResponseEntity<>( productoService.eliminarProducto(productoId),HttpStatus.OK);
    }
    
}
