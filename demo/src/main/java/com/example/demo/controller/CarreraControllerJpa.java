package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.DtoCarrera;
import com.example.demo.dtos.DtoCarreraMod;
import com.example.demo.model.Carrera;
import com.example.demo.model.Estudiante;
import com.example.demo.repository.CarreraRepository;
import com.example.demo.servicios.CarreraServicio;

@RestController
@RequestMapping("carreras")
public class CarreraControllerJpa {

    @Qualifier("CarreraServicio")
    @Autowired
    private final CarreraServicio Servicio;

    public CarreraControllerJpa(@Qualifier("CarreraServicio") CarreraServicio Servicio) {
        this.Servicio = Servicio;
    }

    @PostMapping("/")
    public Carrera newCarrera(@RequestBody Carrera e) throws Exception {
        return Servicio.save(e);
    }

    //recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
    @GetMapping("/conEstudiantesOrdenado/")
    public List<DtoCarrera> findCarrerasConInscriptos() throws Exception{return (List<DtoCarrera>) Servicio.findAllCarrerasCantInscriptos();}

    //generar un reporte de las carreras, que para cada carrera incluya información de los
    //inscriptos y egresados por año. Se deben ordenar las carreras alfabéticamente, y
    //presentar los años de manera cronológica
    @GetMapping("/reporte/")
    public List<DtoCarreraMod> findAllIngresantesAndEgresadosOrd() throws Exception{return (List<DtoCarreraMod>) Servicio.findAllIngresantesAndEgresadosOrd();}
}
