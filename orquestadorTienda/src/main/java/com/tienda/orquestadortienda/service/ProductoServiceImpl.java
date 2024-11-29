package com.tienda.orquestadortienda.service;

import com.tienda.orquestadortienda.dtos.ProductoCreateDTO;
import com.tienda.orquestadortienda.dtos.ProductoDTO;
import com.tienda.orquestadortienda.dtos.ProductoUpdateDTO;
import com.tienda.orquestadortienda.feignClient.ProductoFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductoFeignClient productoFeignClient;
    @Override
    public List<ProductoDTO> listarProductosPorIdProveedor(long proveedorId) {
        return productoFeignClient.listarProductosPorIdProveedor(proveedorId);
    }

    @Override
    public ProductoDTO obtenerProductoPorID(long id) {
        return productoFeignClient.obtenerProductoPorID(id);
    }

    @Override
    public ProductoDTO registrarProductos(ProductoCreateDTO productoCreateDTO) {
        return  productoFeignClient.registrarProductos(productoCreateDTO);
    }

    @Override
    public ProductoDTO actualizarProductos(ProductoUpdateDTO productoUpdateDTO) {
        return productoFeignClient.actualizarProductos(productoUpdateDTO);
    }
    
}
