package com.proyectodswii.proveedortienda.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name="tb_proveedor")
@Getter
@Setter
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_proveedor")
    private long id;

    @Column(name="nombre", nullable = false)
    private String nombre;

    @Column(name="direccion", nullable = false)
    private String direccion;

    @Column(name="telefono", nullable = false)
    private String telefono;

    @Column(name="sitioweb", nullable = false)
    private String sitioweb;
}
