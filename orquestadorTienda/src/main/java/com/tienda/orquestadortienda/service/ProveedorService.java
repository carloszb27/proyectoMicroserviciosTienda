package com.tienda.orquestadortienda.service;

import com.tienda.orquestadortienda.dtos.ProveedorCreateDTO;
import com.tienda.orquestadortienda.dtos.ProveedorDTO;
import com.tienda.orquestadortienda.dtos.ProveedorUpdateDTO;

import java.util.List;

public interface ProveedorService {

    List<ProveedorDTO> listarProveedor();
    ProveedorDTO obtenerProveedorPorID(long id);
    ProveedorDTO registrarProveedor(ProveedorCreateDTO empleadoCreateDTO);
    ProveedorDTO actualizarProveedor(ProveedorUpdateDTO empleadoUpdateDTO);
}
