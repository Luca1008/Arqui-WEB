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

import com.example.demo.dtos.DtoEstudiante;
import com.example.demo.model.Estudiante;
import com.example.demo.servicios.EstudianteServicio;

@RestController
@RequestMapping("estudiantes")
public class EstudianteControllerJpa {

    @Qualifier("EstudianteServicio")
    @Autowired
    private final EstudianteServicio servicio;

    public EstudianteControllerJpa(@Qualifier("EstudianteServicio") EstudianteServicio servicio) {
        this.servicio = servicio;
    }

    //dar de alta un estudiante
    @PostMapping("/")
    public Estudiante newEstudiante(@RequestBody Estudiante e) throws Exception {
        return servicio.save(e);
    }
    @GetMapping("/")
    public List<DtoEstudiante> findAllEstudiantes() throws Exception {
        return servicio.findAll();
    }

    //recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple
    @GetMapping("/ordenar/{sort}")
    public List<DtoEstudiante> findEstudiantesOrdenados(@PathVariable String sort) throws Exception {
        return servicio.findEstudiantesOrdenados(sort);
    }

    //recuperar un estudiante, en base a su número de libreta universitaria
    @GetMapping("/libreta/{lu}")
    public DtoEstudiante findEstudiantePorNumLibreta(@PathVariable int lu) throws Exception {
        return servicio.findEstudianteByLibrEstudiante(lu);
    }

    //recuperar todos los estudiantes, en base a su género
    @GetMapping("/genero/{genero}")
    public List<DtoEstudiante> findEstudiantesByGenero(@PathVariable String genero) throws Exception {
        return servicio.findByGenero(genero);
    }

    @GetMapping("/{id}")
    public DtoEstudiante findEstudiante(@PathVariable Long id) throws Exception {
        return servicio.findById(id);
    }

}
