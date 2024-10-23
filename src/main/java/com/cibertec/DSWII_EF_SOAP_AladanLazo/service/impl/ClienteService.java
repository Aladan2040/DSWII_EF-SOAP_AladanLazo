package com.cibertec.DSWII_EF_SOAP_AladanLazo.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.cibertec.ws.objects.GetClienteResponse;
import com.cibertec.ws.objects.GetClientesResponse;
import com.cibertec.ws.objects.PostClienteRequest;
import com.cibertec.ws.objects.PostClienteResponse;
import com.cibertec.DSWII_EF_SOAP_AladanLazo.exception.NotFoundException;
import com.cibertec.DSWII_EF_SOAP_AladanLazo.model.Cliente;
import com.cibertec.DSWII_EF_SOAP_AladanLazo.repository.ClienteRepository;
import com.cibertec.DSWII_EF_SOAP_AladanLazo.service.IClienteService;
import com.cibertec.DSWII_EF_SOAP_AladanLazo.util.convert.ClienteConvert;

@RequiredArgsConstructor
@Service
public class ClienteService implements IClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteConvert clienteConvert;

    @Override
    @Transactional
    public GetClientesResponse listarClientes() {
        GetClientesResponse getClientesResponse = new GetClientesResponse();
        getClientesResponse.getClientes().addAll(
                clienteConvert.mapToClienteWsList(clienteRepository.findAll())
        );
        return getClientesResponse;
    }

    @Override
    @Transactional
    public GetClienteResponse obtenerClientexId(Long id) {
        GetClienteResponse clienteResponse = new GetClienteResponse();
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if (cliente == null) {
            throw new NotFoundException("El cliente con ID " + id + " no existe.");
        }
        clienteResponse.setCliente(
                clienteConvert.mapToClientews(cliente));
        return clienteResponse;
    }

    @Override
    @Transactional
    public PostClienteResponse registrarCliente(PostClienteRequest request) {
        PostClienteResponse postClienteResponse = new PostClienteResponse();
        Cliente nuevoCliente = clienteRepository.save(
                clienteConvert.mapToCliente(request.getCliente())
        );
        postClienteResponse.setCliente(
                clienteConvert.mapToClientews(nuevoCliente));
        return postClienteResponse;
    }

    @Override
    @Transactional
    public PostClienteResponse actualizarCliente(Long id, PostClienteRequest request) {
        PostClienteResponse postClienteResponse = new PostClienteResponse();
        Cliente clienteExistente = clienteRepository.findById(id).orElse(null);
        if (clienteExistente == null) {
            throw new NotFoundException("El cliente con ID " + id + " no existe.");
        }
        // Actualizar los campos del cliente existente
        clienteExistente.setNombre(request.getCliente().getNombre());
        clienteExistente.setDireccion(request.getCliente().getDireccion());
        clienteExistente.setTelefono(request.getCliente().getTelefono());
        clienteExistente.setEmail(request.getCliente().getEmail());

        Cliente clienteActualizado = clienteRepository.save(clienteExistente);
        postClienteResponse.setCliente(clienteConvert.mapToClientews(clienteActualizado));
        return postClienteResponse;
    }
}