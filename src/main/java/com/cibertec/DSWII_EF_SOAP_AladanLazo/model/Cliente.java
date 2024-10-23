package com.cibertec.DSWII_EF_SOAP_AladanLazo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Cambiado a Long para reflejar el tipo de ID
    private String nombre;
    private String direccion; // Opcional
    private String telefono; // Opcional
    private String email; // Opcional


}