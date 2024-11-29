package com.tienda.orquestadortienda.service;

import com.tienda.orquestadortienda.dtos.ClienteDTO;
import com.tienda.orquestadortienda.dtos.ProductoDTO;
import com.tienda.orquestadortienda.dtos.ProveedorConsultaDTO;
import com.tienda.orquestadortienda.dtos.ProveedorDTO;
import com.tienda.orquestadortienda.feignClient.ClienteFeignClient;
import com.tienda.orquestadortienda.feignClient.ProductoFeignClient;
import com.tienda.orquestadortienda.feignClient.ProveedorFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class ConsultaServiceImpl implements ConsultaService {
    
    private final ProveedorFeignClient proveedorFeignClient;
    private final ClienteFeignClient clienteFeignClient;
    private final ProductoFeignClient productoFeignClient;


    @Override
    public ProveedorConsultaDTO consultarProveedorPorId(long id) {

        //ProveedorDTO proveedorDTO = proveedorFeignClient.obtenerProveedorPorId(id);
        //List<ClienteDTO> clienteDTO = clienteFeignClient.listarClientePorIdProveedor(id);
        //List<ProductoDTO> productoDTO = productoFeignClient.listarProductosPorIdProveedor(id);

        CompletableFuture<ProveedorDTO> proveedorFuture =
                CompletableFuture.supplyAsync(() -> proveedorFeignClient.obtenerProveedorPorId(id));

        CompletableFuture<List<ClienteDTO>> clienteFuture =
                CompletableFuture.supplyAsync(() -> clienteFeignClient.listarClientePorIdProveedor(id));

        CompletableFuture<List<ProductoDTO>> productoFuture =
                CompletableFuture.supplyAsync(() -> productoFeignClient.listarProductosPorIdProveedor(id));

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(proveedorFuture, clienteFuture, productoFuture);
        allFutures.join();

        ProveedorDTO proveedorDTO = proveedorFuture.join();
        List<ClienteDTO> clienteDTO = clienteFuture.join();
        List<ProductoDTO> productoDTO = productoFuture.join();

        ProveedorConsultaDTO proveedorConsultaDTO = new ProveedorConsultaDTO();
        proveedorConsultaDTO.setProveedor(proveedorDTO);
        proveedorConsultaDTO.setCliente(clienteDTO);
        proveedorConsultaDTO.setProductos(productoDTO);

        return proveedorConsultaDTO;
    }

}
