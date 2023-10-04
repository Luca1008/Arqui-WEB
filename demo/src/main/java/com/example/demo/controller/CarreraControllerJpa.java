package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Carrera;
import com.example.demo.repository.CarreraRepository;

@RestController
@RequestMapping("carreras")
public class CarreraControllerJpa {

    @Qualifier("carreraRepository")
    @Autowired
    private final CarreraRepository repository;

    public CarreraControllerJpa(@Qualifier("carreraRepository") CarreraRepository repository) {
        this.repository = repository;
    }

    // @GetMapping("/carreras/conEstudiantesOrdenado/")
    // public List<Carrera> findCarrerasConInscriptos(){return repository.carrerasConInscriptos();}
}
