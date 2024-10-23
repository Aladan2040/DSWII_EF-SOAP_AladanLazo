package com.cibertec.DSWII_EF_SOAP_AladanLazo.util.convert;

import org.springframework.stereotype.Component;
import com.cibertec.ws.objects.Productows;
import com.cibertec.DSWII_EF_SOAP_AladanLazo.model.Producto;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductoConvert {

    public Producto mapToProducto(Productows productows) {
        Producto producto = new Producto();
        producto.setId(productows.getId());
        producto.setNombre(productows.getNombre());
        producto.setPrecio(productows.getPrecio());
        producto.setStock(productows.getStock());
        return producto;
    }

    public Productows mapToProductows(Producto producto) {
        Productows productows = new Productows();
        productows.setId(producto.getId());
        productows.setNombre(producto.getNombre());
        productows.setPrecio(producto.getPrecio());
        productows.setStock(producto.getStock());
        return productows;
    }

    public List<Producto> mapToProductoList(List<Productows> productowsList) {
        List<Producto> productoList = new ArrayList<>();
        for (Productows productows : productowsList) {
            productoList.add(mapToProducto(productows));
        }
        return productoList;
    }

    public List<Productows> mapToProductowsList(List<Producto> productoList) {
        List<Productows> productowsList = new ArrayList<>();
        for (Producto producto : productoList) {
            productowsList.add(mapToProductows(producto));
        }
        return productowsList;
    }
}
