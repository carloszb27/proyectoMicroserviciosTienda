package com.proyectodswii.proveedortienda.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProveedorDTO {

    private long id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String sitioweb;
}
