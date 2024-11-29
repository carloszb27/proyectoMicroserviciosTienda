package com.proyectodswii.clientestienda.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ClienteDTO {

    private Long id;
    private String nombre;
    private Date fechaNac;
    private String direccion;
    private String telefono;
    private String email;
    private Long idProveedor;
}
