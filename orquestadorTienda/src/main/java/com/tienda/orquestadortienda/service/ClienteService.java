package com.tienda.orquestadortienda.service;

import com.tienda.orquestadortienda.dtos.ClienteCreateDTO;
import com.tienda.orquestadortienda.dtos.ClienteDTO;
import com.tienda.orquestadortienda.dtos.ClienteUpdateDTO;

import java.util.List;

public interface ClienteService {

    List<ClienteDTO> listarClientePorIdProveedor(long proveedorId);
    ClienteDTO obtenerClientePorID(long id);
    ClienteDTO registrarCliente(ClienteCreateDTO clienteCreateDTO);
    ClienteDTO actualizarCliente(ClienteUpdateDTO clienteUpdateDTO);
}
