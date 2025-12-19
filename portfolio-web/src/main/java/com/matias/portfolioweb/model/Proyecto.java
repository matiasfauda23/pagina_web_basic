package com.matias.portfolioweb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity     //Le decimos a Spring "Hace una tabla con esta clase"
@Data       //Lombok: Crea getters y setters, toString automaticamente

public class Proyecto {
    @Id     //Indicamos que es la primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //Autoincrementable
    private Long id;

    private String nombre;
    private String descripcion;
    private String urlImagen;
}
