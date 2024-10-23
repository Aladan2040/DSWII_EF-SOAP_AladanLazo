package com.cibertec.DSWII_EF_SOAP_AladanLazo.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.cibertec.ws.objects.*;
import com.cibertec.DSWII_EF_SOAP_AladanLazo.service.IProductoService;

@Endpoint
public class ProductoEndPoint {

    private static final String NAMESPACE_URI = "http://www.cibertec.com/ws/objects";

    @Autowired
    private IProductoService productoService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductosRequest")
    @ResponsePayload
    public GetProductosResponse getProductos(@RequestPayload GetProductosRequest request) {
        return productoService.listarProductos();
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductoRequest")
    @ResponsePayload
    public GetProductoResponse getProductoXid(@RequestPayload GetProductoRequest request) {
        return productoService.obtenerProductoxId(request.getId());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postProductoRequest")
    @ResponsePayload
    public PostProductoResponse saveProducto(@RequestPayload PostProductoRequest request) {
        return productoService.registrarProducto(request);
    }
}