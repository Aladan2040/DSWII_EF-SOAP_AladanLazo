package com.cibertec.DSWII_EF_SOAP_AladanLazo.util.convert;

import org.springframework.stereotype.Component;
import com.cibertec.ws.objects.Clientews;
import com.cibertec.DSWII_EF_SOAP_AladanLazo.model.Cliente;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClienteConvert {

    public Cliente mapToCliente(Clientews clientews) {
        Cliente cliente = new Cliente();
        cliente.setId(cliente.getId());
        cliente.setNombre(clientews.getNombre());
        cliente.setDireccion(clientews.getDireccion());
        cliente.setTelefono(clientews.getTelefono());
        cliente.setEmail(clientews.getEmail());
        return cliente;
    }

    public Clientews mapToClientews(Cliente cliente) {
        Clientews clientews = new Clientews();
        clientews.setId(cliente.getId());
        clientews.setNombre(cliente.getNombre());
        clientews.setDireccion(cliente.getDireccion());
        clientews.setTelefono(cliente.getTelefono());
        clientews.setEmail(cliente.getEmail());
        return clientews;
    }

    public List<Cliente> mapToClienteList(List<Clientews> clientewsList) {
        List<Cliente> clienteList = new ArrayList<>();
        for (Clientews clientews : clientewsList) {
            clienteList.add(mapToCliente(clientews));
        }
        return clienteList;
    }

    public List<Clientews> mapToClienteWsList(List<Cliente> clienteList) {
        List<Clientews> clientewsList = new ArrayList<>();
        for (Cliente cliente : clienteList) {
            clientewsList.add(mapToClientews(cliente));
        }
        return clientewsList;
    }
}