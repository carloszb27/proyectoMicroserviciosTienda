package com.proyectodswii.productostienda.repository;

import com.proyectodswii.productostienda.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    List<Producto> findAllByIdProveedor(long idProveedor);
}
