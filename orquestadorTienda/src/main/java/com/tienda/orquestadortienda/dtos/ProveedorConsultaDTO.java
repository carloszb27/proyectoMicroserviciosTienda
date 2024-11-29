package com.tienda.orquestadortienda.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProveedorConsultaDTO {

    private ProveedorDTO proveedor;
    private List<ClienteDTO> cliente;
    private List<ProductoDTO> productos;
}
