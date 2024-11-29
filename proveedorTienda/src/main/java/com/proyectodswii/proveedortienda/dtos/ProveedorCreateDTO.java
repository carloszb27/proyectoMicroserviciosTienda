package com.proyectodswii.proveedortienda.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProveedorCreateDTO {

    private String nombre;
    private String direccion;
    private String telefono;
    private String sitioweb;
    private List<ClienteCreateDTO> cliente;
}
