package com.cibertec.DSWII_EF_SOAP_AladanLazo.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Cambiado a Long para reflejar el tipo de ID
    private String nombre;
    private String tipo;
    private BigDecimal precio; // Cambiado a Double para manejar decimales
    private Integer stock;
}
