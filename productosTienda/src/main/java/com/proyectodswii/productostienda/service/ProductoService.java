package com.proyectodswii.productostienda.service;

import com.proyectodswii.productostienda.dtos.ProductoCreateDTO;
import com.proyectodswii.productostienda.dtos.ProductoDTO;
import com.proyectodswii.productostienda.dtos.ProductoUpdateDTO;

import java.util.List;

public interface ProductoService {
    List<ProductoDTO> listarProductosPorIdProveedor(long proveedorId);
    ProductoDTO obtenerProductoPorID(long id);
    ProductoDTO registrarProductos(ProductoCreateDTO productoCreateDTO);
    ProductoDTO actualizarProductos(ProductoUpdateDTO productoUpdateDTO);
    String eliminarProducto(long id);
}
