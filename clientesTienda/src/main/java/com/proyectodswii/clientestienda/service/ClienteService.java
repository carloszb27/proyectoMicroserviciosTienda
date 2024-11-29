package com.proyectodswii.clientestienda.service;

import com.proyectodswii.clientestienda.dtos.ClienteCreateDTO;
import com.proyectodswii.clientestienda.dtos.ClienteDTO;
import com.proyectodswii.clientestienda.dtos.ClienteUpdateDTO;

import java.util.List;

public interface ClienteService {
    
    List<ClienteDTO> listarClientePorIdProveedor(long proveedorId);
    ClienteDTO obtenerClientePorID(long id);
    ClienteDTO registrarCliente(ClienteCreateDTO clienteCreateDTO);
    ClienteDTO actualizarCliente(ClienteUpdateDTO clienteUpdateDTO);
    String eliminarCliente(long id);
}
