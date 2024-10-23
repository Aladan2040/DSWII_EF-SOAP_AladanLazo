package com.cibertec.DSWII_EF_SOAP_AladanLazo.service;

import com.cibertec.ws.objects.GetClienteResponse;
import com.cibertec.ws.objects.GetClientesResponse;
import com.cibertec.ws.objects.PostClienteRequest;
import com.cibertec.ws.objects.PostClienteResponse;
import com.cibertec.DSWII_EF_SOAP_AladanLazo.model.Cliente;

import java.util.List;

public interface IClienteService {

    GetClientesResponse listarClientes();

    GetClienteResponse obtenerClientexId(Long id);

    PostClienteResponse registrarCliente(PostClienteRequest request);

    PostClienteResponse actualizarCliente(Long id, PostClienteRequest request);
}
