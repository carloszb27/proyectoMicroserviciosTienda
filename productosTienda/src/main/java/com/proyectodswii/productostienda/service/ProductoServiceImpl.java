package com.proyectodswii.productostienda.service;

import com.proyectodswii.productostienda.dtos.ProductoCreateDTO;
import com.proyectodswii.productostienda.dtos.ProductoDTO;
import com.proyectodswii.productostienda.dtos.ProductoUpdateDTO;
import com.proyectodswii.productostienda.mappers.ProductoMapper;
import com.proyectodswii.productostienda.model.Producto;
import com.proyectodswii.productostienda.repository.ProductoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    @Override
    public List<ProductoDTO> listarProductosPorIdProveedor(long proveedorId) {
        return ProductoMapper.instancia.listaProductoAListaProductoDTO( productoRepository.findAllByIdProveedor(proveedorId)) ;
    }

    @Override
    public ProductoDTO obtenerProductoPorID(long id) {
        return productoRepository.findById(id)
                .map(ProductoMapper.instancia::productoAProductoDTO)
                .orElseThrow(()->new RuntimeException("Producto no encontrado con ID " +id));
    }

    @Override
    public ProductoDTO registrarProductos(ProductoCreateDTO productoCreateDTO) {
        Producto producto= ProductoMapper.instancia.productoCreateDTOAProducto (productoCreateDTO);
        Producto respuestaEntity=productoRepository.save(producto);
        return  ProductoMapper.instancia.productoAProductoDTO(respuestaEntity);
    }

    @Override
    public ProductoDTO actualizarProductos(ProductoUpdateDTO productoUpdateDTO) {
        Producto producto= ProductoMapper.instancia.productoUpdateDTOAProducto (productoUpdateDTO);
        Producto respuestaEntity=productoRepository.save(producto);
        return ProductoMapper.instancia.productoAProductoDTO(respuestaEntity);
    }

    @Override
    public String eliminarProducto(long id) {
        if (productoRepository.existsById(id)){
            productoRepository.deleteById(id);
            return "Producto con ID "+id+" ha sido eliminado correctamente";
        }else{
            return "No se puede eliminar el registro. ID no encontrado :"+id;
        }
    }
}
