package com.cibertec.DSWII_EF_SOAP_AladanLazo.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.cibertec.ws.objects.GetProductoResponse;
import com.cibertec.ws.objects.GetProductosResponse;
import com.cibertec.ws.objects.PostProductoRequest;
import com.cibertec.ws.objects.PostProductoResponse;
import com.cibertec.DSWII_EF_SOAP_AladanLazo.exception.NotFoundException;
import com.cibertec.DSWII_EF_SOAP_AladanLazo.model.Producto;
import com.cibertec.DSWII_EF_SOAP_AladanLazo.repository.ProductoRepository;
import com.cibertec.DSWII_EF_SOAP_AladanLazo.service.IProductoService;
import com.cibertec.DSWII_EF_SOAP_AladanLazo.util.convert.ProductoConvert;

@RequiredArgsConstructor
@Service
public class ProductoService implements IProductoService {

    private final ProductoRepository productoRepository;
    private final ProductoConvert productoConvert;

    @Override
    @Transactional
    public GetProductosResponse listarProductos() {
        GetProductosResponse getProductosResponse = new GetProductosResponse();
        getProductosResponse.getProductos().addAll(
                productoConvert.mapToProductowsList(productoRepository.findAll())
        );
        return getProductosResponse;
    }

    @Override
    @Transactional
    public GetProductoResponse obtenerProductoxId(Long id) {
        GetProductoResponse productoResponse = new GetProductoResponse();
        Producto producto = productoRepository.findById(id).orElse(null);
        if (producto == null) {
            throw new NotFoundException("El producto con ID " + id + " no existe.");
        }
        productoResponse.setProducto(
                productoConvert.mapToProductows(producto));
        return productoResponse;
    }

    @Override
    @Transactional
    public PostProductoResponse registrarProducto(PostProductoRequest request) {
        PostProductoResponse postProductoResponse = new PostProductoResponse();
        Producto nuevoProducto = productoRepository.save(
                productoConvert.mapToProducto(request.getProducto())
        );
        postProductoResponse.setProducto(
                productoConvert.mapToProductows(nuevoProducto));
        return postProductoResponse;
    }

    @Override
    @Transactional
    public PostProductoResponse actualizarProducto(Long id, PostProductoRequest request) {
        PostProductoResponse postProductoResponse = new PostProductoResponse();
        Producto productoExistente = productoRepository.findById(id).orElse(null);
        if (productoExistente == null) {
            throw new NotFoundException("El producto con ID " + id + " no existe.");
        }
        // Actualizar los campos del producto existente
        productoExistente.setNombre(request.getProducto().getNombre());
        productoExistente.setPrecio(request.getProducto().getPrecio());
        productoExistente.setStock(request.getProducto().getStock());

        Producto productoActualizado = productoRepository.save(productoExistente);
        postProductoResponse.setProducto(productoConvert.mapToProductows(productoActualizado));
        return postProductoResponse;
    }
}
