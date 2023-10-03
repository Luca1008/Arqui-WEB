package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CarreraEstudiante;
import com.example.demo.repository.EstudianteCarreraRepository;

@RestController
public class ECControlerJpa {

    @Qualifier("estudianteCarreraRepository")
    @Autowired
    private final EstudianteCarreraRepository repository;

    public ECControlerJpa(@Qualifier("estudianteCarreraRepository") EstudianteCarreraRepository repository){
        this.repository = repository;
    }

    @PostMapping("/estudiante")
    public CarreraEstudiante newEstudiante(@RequestBody CarreraEstudiante c) {return repository.save(c);}

}
