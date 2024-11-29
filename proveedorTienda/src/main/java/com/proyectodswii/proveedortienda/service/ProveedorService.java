package com.proyectodswii.proveedortienda.service;

import com.proyectodswii.proveedortienda.dtos.ProveedorCreateDTO;
import com.proyectodswii.proveedortienda.dtos.ProveedorDTO;
import com.proyectodswii.proveedortienda.dtos.ProveedorUpdateDTO;

import java.util.List;

public interface ProveedorService {
    
    List<ProveedorDTO> listarProveedor();
    ProveedorDTO obtenerProveedorPorID(long id);
    ProveedorDTO registrarProveedor(ProveedorCreateDTO proveedorCreateDTO);
    ProveedorDTO actualizarProveedor(ProveedorUpdateDTO proveedorUpdateDTO);
    String eliminarProveedor(long id);
}
