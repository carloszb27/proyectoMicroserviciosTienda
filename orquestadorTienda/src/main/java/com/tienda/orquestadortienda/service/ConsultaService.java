package com.tienda.orquestadortienda.service;

import com.tienda.orquestadortienda.dtos.ProveedorConsultaDTO;

public interface ConsultaService {

    ProveedorConsultaDTO consultarProveedorPorId(long id);
}
