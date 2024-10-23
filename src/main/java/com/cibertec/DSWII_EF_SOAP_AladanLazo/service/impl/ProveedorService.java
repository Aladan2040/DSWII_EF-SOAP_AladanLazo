package com.cibertec.DSWII_EF_SOAP_AladanLazo.service.impl;

import com.cibertec.DSWII_EF_SOAP_AladanLazo.util.convert.ProveedorConvert;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.cibertec.ws.objects.GetProveedorResponse;
import com.cibertec.ws.objects.GetProveedoresResponse;
import com.cibertec.ws.objects.PostProveedorRequest;
import com.cibertec.ws.objects.PostProveedorResponse;
import com.cibertec.DSWII_EF_SOAP_AladanLazo.exception.NotFoundException;
import com.cibertec.DSWII_EF_SOAP_AladanLazo.model.Proveedor;
import com.cibertec.DSWII_EF_SOAP_AladanLazo.repository.ProveedorRepository;
import com.cibertec.DSWII_EF_SOAP_AladanLazo.service.IProveedorService;

@RequiredArgsConstructor
@Service
public class ProveedorService implements IProveedorService {

    private final ProveedorRepository proveedorRepository;
    private final ProveedorConvert proveedorConvert;

    @Override
    @Transactional
    public GetProveedoresResponse listarProveedores() {
        GetProveedoresResponse getProveedoresResponse = new GetProveedoresResponse();
        getProveedoresResponse.getProveedores().addAll(
                proveedorConvert.mapToProveedorwsList(proveedorRepository.findAll())
        );
        return getProveedoresResponse;
    }

    @Override
    @Transactional
    public GetProveedorResponse obtenerProveedorexId(Long id) {
        GetProveedorResponse proveedorResponse = new GetProveedorResponse();
        Proveedor proveedor = proveedorRepository.findById(id).orElse(null);
        if (proveedor == null) {
            throw new NotFoundException("El proveedor con ID " + id + " no existe.");
        }
        proveedorResponse.setProveedor(
                proveedorConvert.mapToProveedorws(proveedor));
        return proveedorResponse;
    }

    @Override
    @Transactional
    public PostProveedorResponse registrarProveedor(PostProveedorRequest request) {
        PostProveedorResponse postProveedorResponse = new PostProveedorResponse();
        Proveedor nuevoProveedor = proveedorRepository.save(
                proveedorConvert.mapToProveedor(request.getProveedor())
        );
        postProveedorResponse.setProveedor(
                proveedorConvert.mapToProveedorws(nuevoProveedor));
        return postProveedorResponse;
    }

    @Override
    @Transactional
    public PostProveedorResponse actualizarProveedor(Long id, PostProveedorRequest request) {
        PostProveedorResponse postProveedorResponse = new PostProveedorResponse();
        Proveedor proveedorExistente = proveedorRepository.findById(id).orElse(null);
        if (proveedorExistente == null) {
            throw new NotFoundException("El proveedor con ID " + id + " no existe.");
        }
        // Actualizar los campos del proveedor existente
        proveedorExistente.setNombre(request.getProveedor().getNombre());
        proveedorExistente.setDireccion(request.getProveedor().getDireccion());
        proveedorExistente.setTelefono(request.getProveedor().getTelefono());
        proveedorExistente.setEmail(request.getProveedor().getEmail());

        Proveedor proveedorActualizado = proveedorRepository.save(proveedorExistente);
        postProveedorResponse.setProveedor(proveedorConvert.mapToProveedorws(proveedorActualizado));
        return postProveedorResponse;
    }
}