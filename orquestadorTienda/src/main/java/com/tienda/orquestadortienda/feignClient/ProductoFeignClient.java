package com.tienda.orquestadortienda.feignClient;

import com.tienda.orquestadortienda.dtos.ProductoCreateDTO;
import com.tienda.orquestadortienda.dtos.ProductoDTO;
import com.tienda.orquestadortienda.dtos.ProductoUpdateDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="productos-api", url ="http://localhost:8083/api")
public interface ProductoFeignClient {

    @GetMapping("/productos/proveedores/{proveedorId}")
    List<ProductoDTO> listarProductosPorIdProveedor(@PathVariable("proveedorId")  long proveedorId);
    @GetMapping("/productos/{productoId}")
    ProductoDTO obtenerProductoPorID(@PathVariable("productoId") long productoId);
    @PostMapping("/productos")
    ProductoDTO registrarProductos(@RequestBody ProductoCreateDTO productoCreateDTO);
    @PutMapping("/productos")
    ProductoDTO actualizarProductos(@RequestBody ProductoUpdateDTO productoUpdateDTO);
}
