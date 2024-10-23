package com.cibertec.DSWII_EF_SOAP_AladanLazo.service;

import com.cibertec.ws.objects.GetProveedorResponse;
import com.cibertec.ws.objects.GetProveedoresResponse;
import com.cibertec.ws.objects.PostProveedorRequest;
import com.cibertec.ws.objects.PostProveedorResponse;
import com.cibertec.DSWII_EF_SOAP_AladanLazo.model.Proveedor;

import java.util.List;

public interface IProveedorService {

    GetProveedoresResponse listarProveedores();

    GetProveedorResponse obtenerProveedorexId(Long id);

    PostProveedorResponse registrarProveedor(PostProveedorRequest request);

    PostProveedorResponse actualizarProveedor(Long id, PostProveedorRequest request);
}
