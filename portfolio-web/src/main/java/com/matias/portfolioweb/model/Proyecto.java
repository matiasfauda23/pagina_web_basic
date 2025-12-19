package com.matias.portfolioweb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
//Herramientas para validaciones
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity     //Le decimos a Spring "Hace una tabla con esta clase"
@Data       //Lombok: Crea getters y setters, toString automaticamente

public class Proyecto {
    @Id     //Declaramos que es la primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //Autoincrementable
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacio") //Quiero que esto no este vacio
    private String nombre;

    @Size(min = 5, max = 200, message = "La descripcion debe tener entre 5 y 200 caracteres")
    private String descripcion;

    @NotBlank(message = "Deber tener URL de imagen")
    private String urlImagen;
}
