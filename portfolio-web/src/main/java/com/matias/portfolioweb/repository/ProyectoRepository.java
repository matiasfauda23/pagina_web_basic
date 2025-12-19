package com.matias.portfolioweb.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.matias.portfolioweb.model.Proyecto;

//En Spring no usamos instrucciones como INSERT o INTO
//Creamos interfaz que herede JpaRepository y obtenemos varios metodos:
//.save() - .findAll() - .findAll() - .delete()


import org.springframework.data.jpa.repository.JpaRepository;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
}
