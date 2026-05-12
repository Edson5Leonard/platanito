package com.instagram.instagram.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Producto {

    @Id
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    
    private Long id;
    private String marca;

    private String nombre;

    private String modelo;

    private double precio;

    private String descripcion;

    private String color;

    private Integer descuento;

    private String genero;

    private String categoria;

    private String subcategoria;

    
}
