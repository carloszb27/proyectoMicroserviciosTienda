package com.tienda.orquestadortienda.service;

import com.tienda.orquestadortienda.dtos.ClienteCreateDTO;
import com.tienda.orquestadortienda.dtos.ClienteDTO;
import com.tienda.orquestadortienda.dtos.ClienteUpdateDTO;
import com.tienda.orquestadortienda.feignClient.ClienteFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {
    
    private final ClienteFeignClient clienteFeignClient;

    @Override
    public List<ClienteDTO> listarClientePorIdProveedor(long proveedorId) {
        return clienteFeignClient.listarClientePorIdProveedor(proveedorId);
    }

    @Override
    public ClienteDTO obtenerClientePorID(long id) {
        return clienteFeignClient.obtenerClientePorId(id);
    }

    @Override
    public ClienteDTO registrarCliente(ClienteCreateDTO clienteCreateDTO) {
        return clienteFeignClient.registrarCliente(clienteCreateDTO);
    }

    @Override
    public ClienteDTO actualizarCliente(ClienteUpdateDTO clienteUpdateDTO) {
        return clienteFeignClient.actualizarCliente(clienteUpdateDTO);
    }
    
}
