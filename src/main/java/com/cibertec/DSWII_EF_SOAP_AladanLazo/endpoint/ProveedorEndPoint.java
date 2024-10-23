package com.cibertec.DSWII_EF_SOAP_AladanLazo.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.cibertec.ws.objects.*;
import com.cibertec.DSWII_EF_SOAP_AladanLazo.service.IProveedorService;

@Endpoint
public class ProveedorEndPoint {

    private static final String NAMESPACE_URI = "http://www.cibertec.edu.pe/ws/objects";

    @Autowired
    private IProveedorService proveedorService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProveedoresRequest")
    @ResponsePayload
    public GetProveedoresResponse getProveedores(@RequestPayload GetProveedoresRequest request) {
        return proveedorService.listarProveedores();
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProveedorRequest")
    @ResponsePayload
    public GetProveedorResponse getProveedorXid(@RequestPayload GetProveedorRequest request) {
        return proveedorService.obtenerProveedorexId(request.getId());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postProveedorRequest")
    @ResponsePayload
    public PostProveedorResponse saveProveedor(@RequestPayload PostProveedorRequest request) {
        return proveedorService.registrarProveedor(request);
    }
}