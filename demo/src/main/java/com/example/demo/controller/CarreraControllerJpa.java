package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Carrera;
import com.example.demo.model.Estudiante;
import com.example.demo.repository.CarreraRepository;
import com.example.demo.servicios.CarreraServicio;

@RestController
@RequestMapping("carreras")
public class CarreraControllerJpa {

    @Qualifier("carreraServicio")
    @Autowired
    private final CarreraServicio Servicio;

    public CarreraControllerJpa(@Qualifier("carreraServicio") CarreraServicio Servicio) {
        this.Servicio = Servicio;
    }

    @PostMapping("/")
    public Carrera newCarrera(@RequestBody Carrera e) throws Exception {
        return Servicio.save(e);
    }

    // @GetMapping("/conEstudiantesOrdenado/")
    // public List<Carrera> findCarrerasConInscriptos(){return repository.carrerasConInscriptos();}
}
