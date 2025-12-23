package com.matias.portfolioweb.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.matias.portfolioweb.model.Proyecto;

//En Spring no usamos instrucciones como INSERT o INTO
//Creamos interfaz que herede JpaRepository y obtenemos varios metodos:
//.save() - .findAll() - .findAll() - .delete()


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
    //Metodo de busqueda
    List<Proyecto> findByNombreContainingIgnoreCase(String palabra);

    //Metodo de filtro
    List<Proyecto> findByCategoriaIgnoreCase(String categoria);
}
