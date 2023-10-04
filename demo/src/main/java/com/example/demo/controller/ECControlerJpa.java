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
import com.example.demo.servicios.EstudianteCarreraServicio;

@RestController
@RequestMapping("EstudianteCarrera")
public class ECControlerJpa {

    @Qualifier("estudianteCarreraRepository")
    @Autowired
    private final EstudianteCarreraServicio servicio;

    public ECControlerJpa(@Qualifier("estudianteCarreraServicio") EstudianteCarreraServicio servicio) {
        this.servicio = servicio;
    }

    @PostMapping("/")
    public EstudianteCarrera newEstudiante(@RequestBody EstudianteCarrera c) throws Exception {
        return servicio.save(c);
    }

    @GetMapping("/")
    public List<EstudianteCarrera> findAll() throws Exception {
        return servicio.findAll();
    }

}
