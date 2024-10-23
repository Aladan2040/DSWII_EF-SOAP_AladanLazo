package com.cibertec.DSWII_EF_SOAP_AladanLazo.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "proveedores")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Cambiado a Long para reflejar el tipo de ID
    private String nombre;
    private String contacto;
    private String direccion;
    private String telefono;
    private String email;
}
