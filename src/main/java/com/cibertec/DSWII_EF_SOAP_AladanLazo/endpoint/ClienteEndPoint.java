package com.cibertec.DSWII_EF_SOAP_AladanLazo.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.cibertec.ws.objects.*;
import com.cibertec.DSWII_EF_SOAP_AladanLazo.service.IClienteService;

@Endpoint
public class ClienteEndPoint {

    private static final String NAMESPACE_URI = "http://www.cibertec.com/ws/objects";

    @Autowired
    private IClienteService clienteService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getClientesRequest")
    @ResponsePayload
    public GetClientesResponse getClientes(@RequestPayload GetClientesRequest request) {
        return clienteService.listarClientes();
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getClienteRequest")
    @ResponsePayload
    public GetClienteResponse getClienteXid(@RequestPayload GetClienteRequest request) {
        return clienteService.obtenerClientexId(request.getId());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postClienteRequest")
    @ResponsePayload
    public PostClienteResponse saveCliente(@RequestPayload PostClienteRequest request) {
        return clienteService.registrarCliente(request);
    }
}