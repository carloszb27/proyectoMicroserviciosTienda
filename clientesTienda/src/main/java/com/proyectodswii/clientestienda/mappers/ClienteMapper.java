package com.proyectodswii.clientestienda.mappers;

import com.proyectodswii.clientestienda.dtos.ClienteCreateDTO;
import com.proyectodswii.clientestienda.dtos.ClienteDTO;
import com.proyectodswii.clientestienda.dtos.ClienteUpdateDTO;
import com.proyectodswii.clientestienda.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClienteMapper {
    
    ClienteMapper instancia= Mappers.getMapper(ClienteMapper.class);

    List<ClienteDTO> listaClienteAListaClienteDTO(List<Cliente> lista);

    ClienteDTO clienteAClienteDTO(Cliente cliente);

    Cliente clienteCreateDTOACliente(ClienteCreateDTO clienteCreateDTO);

    Cliente clienteUpdateDTOACliente(ClienteUpdateDTO clienteUpdateDTO);
}
