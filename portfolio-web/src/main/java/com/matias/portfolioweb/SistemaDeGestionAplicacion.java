package com.matias.portfolioweb;

import com.matias.portfolioweb.model.Proyecto;
import com.matias.portfolioweb.repository.ProyectoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SistemaDeGestionAplicacion {

    public static void main(String[] args) {
        SpringApplication.run(SistemaDeGestionAplicacion.class, args);
    }

//    //Se va a ejutar siempre que le demos iniciar a la aplicacion
//    @Bean
//    public CommandLineRunner demo(ProyectoRepository repository){
//        return (args) -> {
//
//            //Creamos el objeto proyecto
//            Proyecto p1 = new Proyecto();
//            p1.setNombre("Mi primer Portfolio");
//            p1.setDescripcion("Una web creada con Spring Boot desde cero");
//            p1.setUrlImagen("https://upload.wikimedia.org/wikipedia/commons/thumb/c/c1/Google_%22G%22_logo.svg/1200px-Google_%22G%22_logo.svg.png");
//
//            //Guardo el objeto que creamos en la base de datos
//            repository.save(p1);
//
//            System.out.println("El proyecto de prueba fue guardado correctamente");
//        };
//    }

}