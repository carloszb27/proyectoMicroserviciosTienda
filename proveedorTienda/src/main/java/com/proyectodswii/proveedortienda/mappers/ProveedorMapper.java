package com.proyectodswii.proveedortienda.mappers;

import com.proyectodswii.proveedortienda.dtos.ProveedorCreateDTO;
import com.proyectodswii.proveedortienda.dtos.ProveedorDTO;
import com.proyectodswii.proveedortienda.dtos.ProveedorUpdateDTO;
import com.proyectodswii.proveedortienda.model.Proveedor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProveedorMapper {

    ProveedorMapper instancia= Mappers.getMapper(ProveedorMapper.class);

    ProveedorDTO proveedorAProveedorDTO(Proveedor proveedor);
    Proveedor proveedorDTOAProveedor (ProveedorDTO proveedorDTO);
    Proveedor proveedorCreateAProveedor(ProveedorCreateDTO proveedorCreateDTO);
    Proveedor proveedorUpdateAProveedor(ProveedorUpdateDTO proveedorUpdateDTO);
    List<ProveedorDTO> listaProveedorAListaProveedorDTO (List<Proveedor> listaProveedor);
}
