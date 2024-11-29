package com.proyectodswii.productostienda.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ProductoCreateDTO {

    private Long idProveedor;
    private String nombre;
    private int cantidad;
    private double precio;
    private Date fechaVencimiento;
}
