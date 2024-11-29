package com.proyectodswii.clientestienda.service;

import com.proyectodswii.clientestienda.dtos.ClienteCreateDTO;
import com.proyectodswii.clientestienda.dtos.ClienteDTO;
import com.proyectodswii.clientestienda.dtos.ClienteUpdateDTO;
import com.proyectodswii.clientestienda.mappers.ClienteMapper;
import com.proyectodswii.clientestienda.model.Cliente;
import com.proyectodswii.clientestienda.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public List<ClienteDTO> listarClientePorIdProveedor(long proveedorId) {
        return ClienteMapper.instancia
                .listaClienteAListaClienteDTO(clienteRepository.findAllByIdProveedor(proveedorId));
    }

    @Override
    public ClienteDTO obtenerClientePorID(long id) {
        return clienteRepository.findById(id)
                .map(ClienteMapper.instancia::clienteAClienteDTO)
                .orElseThrow(()->new RuntimeException("Cliente no encontrado con ID:"+id));
    }

    @Override
    public ClienteDTO registrarCliente(ClienteCreateDTO clienteCreateDTO) {
        Cliente cliente= ClienteMapper.instancia.clienteCreateDTOACliente(clienteCreateDTO);
        Cliente respuestaEntity= clienteRepository.save(cliente);
        return ClienteMapper.instancia.clienteAClienteDTO(respuestaEntity);
    }

    @Override
    public ClienteDTO actualizarCliente(ClienteUpdateDTO clienteUpdateDTO) {
        Cliente cliente= ClienteMapper.instancia.clienteUpdateDTOACliente(clienteUpdateDTO);
        Cliente respuestaEntity=clienteRepository.save(cliente);
        return ClienteMapper.instancia.clienteAClienteDTO(respuestaEntity);
    }

    @Override
    public String eliminarCliente(long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return "Cliente con ID "+id+" ha sido eliminado correctamente";
        } else {
            return "No se puede eliminar el Cliente . ID no encontrado :"+id;
        }
    }

}
