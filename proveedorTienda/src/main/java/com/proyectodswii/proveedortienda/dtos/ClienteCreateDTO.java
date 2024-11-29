package com.proyectodswii.proveedortienda.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ClienteCreateDTO {

    private String nombre;
    private Date fechaNac;
    private String direccion;
    private String telefono;
    private String email;
    private Long idProveedor;
}
