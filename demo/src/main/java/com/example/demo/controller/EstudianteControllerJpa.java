package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Estudiante;
import com.example.demo.servicios.EstudianteServicio;

@RestController
@RequestMapping("estudiantes")
public class EstudianteControllerJpa {

    @Qualifier("estudianteServicio")
    @Autowired
    private final EstudianteServicio servicio;

    public EstudianteControllerJpa(@Qualifier("estudianteServicio") EstudianteServicio servicio) {
        this.servicio = servicio;
    }

    @PostMapping("/")
    public Estudiante newEstudiante(@RequestBody Estudiante e) throws Exception {
        return servicio.save(e);
    }

    @GetMapping("/ordenar/{sort}")
    public List<Estudiante> findEstudiantesOrdenados(@PathVariable String sort) throws Exception {
        return servicio.findEstudiantesOrdenados(sort);
    }

    @GetMapping("/libreta/{lu}")
    public Estudiante findEstudiantePorNumLibreta(@PathVariable int lu) throws Exception {
        return servicio.findEstudianteByLibrEstudiante(lu);
    }

    @GetMapping("/genero/{genero}")
    public List<Estudiante> findEstudiantesByGenero(@PathVariable String genero) throws Exception {
        return servicio.findByGenero(genero);
    }

    @GetMapping("/{id}")
    public Estudiante findEstudiante(@PathVariable Long id) throws Exception {
        return servicio.findById(id);
    }

    @GetMapping("/")
    public List<Estudiante> findAllEstudiantes() throws Exception {
        return servicio.findAll();
    }
}
