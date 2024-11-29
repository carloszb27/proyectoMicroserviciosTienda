package com.tienda.orquestadortienda.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ProductoUpdateDTO {

    private Long id;
    private Long idProveedor;
    private String nombre;
    private int cantidad;
    private double precio;
    private Date fechaVencimiento;
}
