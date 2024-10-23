package com.cibertec.DSWII_EF_SOAP_AladanLazo.service;

import com.cibertec.ws.objects.GetProductoResponse;
import com.cibertec.ws.objects.GetProductosResponse;
import com.cibertec.ws.objects.PostProductoRequest;
import com.cibertec.ws.objects.PostProductoResponse;
import com.cibertec.DSWII_EF_SOAP_AladanLazo.model.Producto;

import java.util.List;

public interface IProductoService {

    GetProductosResponse listarProductos();

    GetProductoResponse obtenerProductoxId(Long id);

    PostProductoResponse registrarProducto(PostProductoRequest request);

    PostProductoResponse actualizarProducto(Long id, PostProductoRequest request);
}
