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
import com.example.demo.model.EstudianteCarrera;
import com.example.demo.servicios.EstudianteCarreraServicio;

@RestController
@RequestMapping("EstudianteCarrera")
public class ECControlerJpa {

    @Qualifier("EstudianteCarreraServicio")
    @Autowired
    private final EstudianteCarreraServicio servicio;

    public ECControlerJpa(@Qualifier("EstudianteCarreraServicio") EstudianteCarreraServicio servicio) {
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

    @GetMapping("/estudiantePorCarreraFiltrado/{carrera}/{ciudad}/")
    public List<DtoEstudiante> findByCarreraFilterCiudad(@PathVariable String carrera, @PathVariable String ciudad) throws Exception {
        return servicio.findByCarreraFilterCiudad(carrera, ciudad);
    }

}
