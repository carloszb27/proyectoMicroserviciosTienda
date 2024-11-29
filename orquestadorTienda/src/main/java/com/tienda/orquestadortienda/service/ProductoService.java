package com.tienda.orquestadortienda.service;

import com.tienda.orquestadortienda.dtos.ProductoCreateDTO;
import com.tienda.orquestadortienda.dtos.ProductoDTO;
import com.tienda.orquestadortienda.dtos.ProductoUpdateDTO;

import java.util.List;

public interface ProductoService {
    
    List<ProductoDTO> listarProductosPorIdProveedor(long proveedorId);
    ProductoDTO obtenerProductoPorID(long id);
    ProductoDTO registrarProductos(ProductoCreateDTO productoCreateDTO);
    ProductoDTO actualizarProductos(ProductoUpdateDTO productoUpdateDTO);
}
