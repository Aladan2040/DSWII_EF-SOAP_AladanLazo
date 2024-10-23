package com.cibertec.DSWII_EF_SOAP_AladanLazo.util.convert;

import org.springframework.stereotype.Component;
import com.cibertec.ws.objects.Proveedorws;
import com.cibertec.DSWII_EF_SOAP_AladanLazo.model.Proveedor;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProveedorConvert {

    public Proveedor mapToProveedor(Proveedorws proveedorws) {
        Proveedor proveedor = new Proveedor();
        proveedor.setId(proveedorws.getId());
        proveedor.setNombre(proveedorws.getNombre());
        proveedor.setDireccion(proveedorws.getDireccion());
        proveedor.setTelefono(proveedorws.getTelefono());
        proveedor.setEmail(proveedorws.getEmail());
        return proveedor;
    }

    public Proveedorws mapToProveedorws(Proveedor proveedor) {
        Proveedorws proveedorws = new Proveedorws();
        proveedorws.setId(proveedor.getId());
        proveedorws.setNombre(proveedor.getNombre());
        proveedorws.setDireccion(proveedor.getDireccion());
        proveedorws.setTelefono(proveedor.getTelefono());
        proveedorws.setEmail(proveedor.getEmail());
        return proveedorws;
    }

    public List<Proveedor> mapToProveedorList(List<Proveedorws> proveedorwsList) {
        List<Proveedor> proveedorList = new ArrayList<>();
        for (Proveedorws proveedorws : proveedorwsList) {
            proveedorList.add(mapToProveedor(proveedorws));
        }
        return proveedorList;
    }

    public List<Proveedorws> mapToProveedorwsList(List<Proveedor> proveedorList) {
        List<Proveedorws> proveedorwsList = new ArrayList<>();
        for (Proveedor proveedor : proveedorList) {
            proveedorwsList.add(mapToProveedorws(proveedor));
        }
        return proveedorwsList;
    }
}