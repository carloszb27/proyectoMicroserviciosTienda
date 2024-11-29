package com.tienda.orquestadortienda.service;

import com.tienda.orquestadortienda.dtos.ProveedorCreateDTO;
import com.tienda.orquestadortienda.dtos.ProveedorDTO;
import com.tienda.orquestadortienda.dtos.ProveedorUpdateDTO;
import com.tienda.orquestadortienda.feignClient.ProveedorFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProveedorServiceImpl implements ProveedorService {
    private final ProveedorFeignClient proveedorFeignClient;

    @Override
    public List<ProveedorDTO> listarProveedor() {
        return proveedorFeignClient.listarProveedores();
    }

    @Override
    public ProveedorDTO obtenerProveedorPorID(long id) {
        return proveedorFeignClient.obtenerProveedorPorId(id);
    }

    @Override
    public ProveedorDTO registrarProveedor(ProveedorCreateDTO proveedorCreateDTO) {
        return proveedorFeignClient.registrarProveedor(proveedorCreateDTO);
    }

    @Override
    public ProveedorDTO actualizarProveedor(ProveedorUpdateDTO proveedorUpdateDTO) {
        return proveedorFeignClient.actualizarProveedor(proveedorUpdateDTO);
    }
}
