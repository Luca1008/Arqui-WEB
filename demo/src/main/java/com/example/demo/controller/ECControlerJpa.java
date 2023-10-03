package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CarreraEstudiante;
import com.example.demo.repository.EstudianteCarreraRepository;

@RestController
@RequestMapping("EstudianteCarrera")
public class ECControlerJpa {

    @Qualifier("estudianteCarreraRepository")
    @Autowired
    private final EstudianteCarreraRepository repository;

    public ECControlerJpa(@Qualifier("estudianteCarreraRepository") EstudianteCarreraRepository repository){
        this.repository = repository;
    }

    //GET - Obtener todos los registros de la tabla de relaciones entre estudiantes y carreras
    
    @RequestMapping("/")
    public Iterable<CarreraEstudiante> getAllEstudiantes(){return repository.findAll();}



    //POST - Crear un registro en la tabla de relaciones entre estudiantes y carreras

    @PostMapping("/")
    public CarreraEstudiante newEstudiante(@RequestBody CarreraEstudiante c) {return repository.save(c);}

    //PUT - Actualizar un registro en la tabla de relaciones entre estudiantes y carreras
    
    @RequestMapping("/update")
    public CarreraEstudiante updateEstudiante(@RequestBody CarreraEstudiante c) {return repository.save(c);}
    
    //DELETE - Borrar un registro en la tabla de relaciones entre estudiantes y carreras
    
    @RequestMapping("/delete")
    public void deleteEstudiante(@RequestBody CarreraEstudiante c) {repository.delete(c);}

    

}
