package com.proyectodswii.proveedortienda.service;

import com.proyectodswii.proveedortienda.dtos.ProveedorCreateDTO;
import com.proyectodswii.proveedortienda.dtos.ProveedorDTO;
import com.proyectodswii.proveedortienda.dtos.ProveedorUpdateDTO;
import com.proyectodswii.proveedortienda.feignClient.ClienteFeignClient;
import com.proyectodswii.proveedortienda.mappers.ProveedorMapper;
import com.proyectodswii.proveedortienda.model.Proveedor;
import com.proyectodswii.proveedortienda.repository.ProveedorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProveedorServiceImpl implements ProveedorService {

    private final ProveedorRepository proveedorRepository;
    private final ClienteFeignClient clienteFeignClient;

    @Override
    public List<ProveedorDTO> listarProveedor() {
        
        return   ProveedorMapper.instancia.listaProveedorAListaProveedorDTO(proveedorRepository.findAll());
    }

    @Override
    public ProveedorDTO obtenerProveedorPorID(long id) {
        
        return proveedorRepository.findById(id)
                .map(ProveedorMapper.instancia::proveedorAProveedorDTO)
                .orElseThrow(()-> new RuntimeException("Proveedor no encontrado con ID: "+ id));
    }

    @Override
    public ProveedorDTO registrarProveedor(ProveedorCreateDTO proveedorCreateDTO) {
        
        Proveedor proveedor =  ProveedorMapper.instancia.proveedorCreateAProveedor(proveedorCreateDTO);
        Proveedor respuesta= proveedorRepository.save(proveedor);

        proveedorCreateDTO.getCliente().forEach(
                itemCliente ->{
                    itemCliente.setIdProveedor(respuesta.getId());
                    clienteFeignClient.registrarCliente(itemCliente);
                }
        );

        return  ProveedorMapper.instancia.proveedorAProveedorDTO(respuesta) ;
    }

    @Override
    public ProveedorDTO actualizarProveedor(ProveedorUpdateDTO proveedorUpdateDTO) {
        
        Proveedor proveedor =  ProveedorMapper.instancia.proveedorUpdateAProveedor(proveedorUpdateDTO);
        Proveedor respuesta= proveedorRepository.save(proveedor);

        proveedorUpdateDTO.getCliente().forEach(
                itemCliente ->{
                    itemCliente.setIdProveedor(respuesta.getId());
                    clienteFeignClient.actualizarCliente(itemCliente);
                }
        );

        return  ProveedorMapper.instancia.proveedorAProveedorDTO(respuesta) ;
    }

    @Override
    public String eliminarProveedor(long id) {
        
        if (proveedorRepository.existsById(id)){
            proveedorRepository.deleteById(id);
            return "Proveedor con ID "+id+" ha sido eliminado correctamente";
        }else{
            return "No se puede eliminar el proveedor. ID no encontrado :"+id;
        }
        
    }
}
