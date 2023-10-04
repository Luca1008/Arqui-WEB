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
import com.example.demo.repository.EstudianteRepository;

@RestController
@RequestMapping("estudiantes")
public class EstudianteControllerJpa {

    @Qualifier("estudianteRepository")
    @Autowired
    private final EstudianteRepository repository;

    public EstudianteControllerJpa(@Qualifier("estudianteRepository") EstudianteRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/")
    public Estudiante newEstudiante(@RequestBody Estudiante e) {
        return repository.save(e);
    }

    @GetMapping("/ordenar/{sort}")
    public List<Estudiante> findEstudiantesOrdenados(@PathVariable String sort) {
        return repository.findEstudiantesOrdenados(sort);
    }

    @GetMapping("/libreta/{lu}")
    public Estudiante findEstudiantePorNumLibreta(@PathVariable int lu) {
        return repository.getEstudianteByLibrEstudiante(lu);
    }

    @GetMapping("/genero/{genero}")
    public List<Estudiante> findEstudiantesByGenero(@PathVariable String genero) {
        return repository.findPorGenero(genero);
    }

    @GetMapping("/{id}")
    public Estudiante findEstudiante(@PathVariable Long id) {
        return repository.getEstudianteById(id);
    }

    @GetMapping("/")
    public List<Estudiante> findAllEstudiantes() {
        return repository.findAll();
    }
}
