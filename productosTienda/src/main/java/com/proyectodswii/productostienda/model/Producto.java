package com.proyectodswii.productostienda.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name="tb_producto")
@Getter
@Setter
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="id_proveedor", nullable = false)
    private long idProveedor;

    @Column(name="nombre", nullable = false)
    private String nombre;

    @Column(name="cantidad", nullable = false)
    private int cantidad;

    @Column(name="precio", nullable = false)
    private double precio;

    @Column(name="fecha_vencimiento", nullable = false)
    @Temporal(value=TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaVencimiento;
}
