package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Estudiante;
import com.example.demo.repository.EstudianteRepository;

@RestController
public class EstudianteControllerJpa {
    
    @Qualifier("estudianteRepository")
    @Autowired
    private final EstudianteRepository repository;

    public EstudianteControllerJpa(@Qualifier("estudianteRepository") EstudianteRepository repository){
        this.repository = repository;
    }

    @PostMapping("/estudiante")
    public Estudiante newEstudiante(@RequestBody Estudiante e) {return repository.save(e);}

    @GetMapping("/estudiantes/porApellido")
    public List<Estudiante> getEstudiantesPorApellido(@RequestBody Estudiante e){}

}
