package com.proyectodswii.productostienda.mappers;

import com.proyectodswii.productostienda.dtos.ProductoCreateDTO;
import com.proyectodswii.productostienda.dtos.ProductoDTO;
import com.proyectodswii.productostienda.dtos.ProductoUpdateDTO;
import com.proyectodswii.productostienda.model.Producto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductoMapper {
    
    ProductoMapper instancia= Mappers.getMapper(ProductoMapper.class);

    List<ProductoDTO> listaProductoAListaProductoDTO(List<Producto> lista);

    ProductoDTO productoAProductoDTO(Producto producto);

    Producto productoCreateDTOAProducto(ProductoCreateDTO productoCreateDTO);

    Producto productoUpdateDTOAProducto(ProductoUpdateDTO productoUpdateDTO);
}
