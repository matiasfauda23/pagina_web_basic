package com.matias.portfolioweb.controller;

import com.matias.portfolioweb.model.Proyecto;
import com.matias.portfolioweb.repository.ProyectoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HomeController {
    //Inyectamos el repositorio para poder buscar en la bd
    private final ProyectoRepository repository;

    //Metodo constructor
    public HomeController(ProyectoRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/")
    public String home(Model model){
        //Busco todos los proyectos de la bd
        List<Proyecto> listaDeProyectos = repository.findAll();

        //Cargamos esa lista en el "modelo"
        model.addAttribute("misProyectos", listaDeProyectos);

        //Retornamos el nombre del archivo
        return "index";
    }

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        // Creamos un objeto Proyecto vacio para que el formulario lo llene
        model.addAttribute("proyecto", new Proyecto());
        return "nuevo_proyecto"; // Mostramos el archivo html nuevo
    }

    @PostMapping("/guardar")
    public String guardarProyecto(@ModelAttribute Proyecto proyecto) {
        // "proyecto" ya viene lleno con los datos del formulario
        repository.save(proyecto); // ¡Lo guardamos en la base de datos!

        return "redirect:/"; // Redirigimos al inicio para ver el cambio
    }

    @GetMapping("/borrar/{id}")
    public String borrarProyecto(@PathVariable Long id) {
        repository.deleteById(id); // Borra el registro con ese ID
        return "redirect:/";       // Vuelve al inicio
    }

    @GetMapping("/editar/{id}")
    public String editarProyecto(@PathVariable Long id, Model model) {
        // Buscamos el proyecto por ID.
        // El .orElse(null) es por si no lo encuentra (aunque acá asumimos que existe).
        Proyecto proyecto = repository.findById(id).orElse(null);

        // Lo ponemos en el modelo con el mismo nombre "proyecto" que usa el formulario
        model.addAttribute("proyecto", proyecto);

        // Reutilizamos la vista del formulario
        return "nuevo_proyecto";
    }
}

