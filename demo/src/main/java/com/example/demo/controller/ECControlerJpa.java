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
import com.example.demo.model.EstudianteCarrera;
import com.example.demo.repository.EstudianteCarreraRepository;

@RestController
@RequestMapping("EstudianteCarrera")
public class ECControlerJpa {

    @Qualifier("estudianteCarreraRepository")
    @Autowired
    private final EstudianteCarreraRepository repository;

    public ECControlerJpa(@Qualifier("estudianteCarreraRepository") EstudianteCarreraRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/")
    public EstudianteCarrera newEstudiante(@RequestBody EstudianteCarrera c) {
        return repository.save(c);
    }

    @GetMapping("/")
    public List<EstudianteCarrera> findAll() {
        return repository.findAll();
    }

}
