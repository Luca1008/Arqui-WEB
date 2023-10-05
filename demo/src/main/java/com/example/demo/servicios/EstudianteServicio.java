package com.example.demo.servicios;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Estudiante;
import com.example.demo.dtos.DtoEstudiante;
import com.example.demo.repository.EstudianteRepository;

import jakarta.transaction.Transactional;
import lombok.var;

@Service("EstudianteServicio")
public class EstudianteServicio {
    @Autowired
    private EstudianteRepository estudianteRepository;


    //Agregar estudiante
    @Transactional
    public Estudiante save(Estudiante estudiante) throws Exception {
        try {
            return estudianteRepository.save(estudiante);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Get - findByID
    @Transactional
    public DtoEstudiante findById(Long id) throws Exception {
        Optional<Estudiante> resultado = estudianteRepository.findById(id);
        try {
            Estudiante as = resultado.get();
            DtoEstudiante es = new DtoEstudiante(as.getId_estudiante(), as.getNombre(), as.getApellido(), as.getEdad(), as.getCiudad(), as.getGenero(), as.getLU());
            return es;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Recuperar Todos los estudiantes
    @Transactional
    public List<DtoEstudiante> findAll() throws Exception {
        var resultado = estudianteRepository.findAll();
        try{
            return resultado.stream().map(Estudiante -> new DtoEstudiante(Estudiante.getId_estudiante(),Estudiante.getNombre(),Estudiante.getApellido(),Estudiante.getEdad(),Estudiante.getCiudad(),Estudiante.getGenero(),Estudiante.getLU())).collect(Collectors.toList());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    //GET - findByGenero, Recuperar los estudiante expecificando el genero 
    @Transactional
    public List<DtoEstudiante> findByGenero(String genero) throws Exception{
        var resultado = estudianteRepository.findPorGenero(genero);
        try {
            return resultado.stream().map(Estudiante -> new DtoEstudiante(Estudiante.getId_estudiante(),Estudiante.getNombre(),Estudiante.getApellido(),Estudiante.getEdad(),Estudiante.getCiudad(),Estudiante.getGenero(),Estudiante.getLU())).collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    //Recuperar todos los estudiantes especificando un metodo de ordenamiento
    @Transactional
    public List<DtoEstudiante> findEstudiantesOrdenados(String sort) throws Exception {
        var resultado = estudianteRepository.findEstudiantesOrdenados(sort);
        try{
            return resultado.stream().map(Estudiante -> new DtoEstudiante(Estudiante.getId_estudiante(),Estudiante.getNombre(),Estudiante.getApellido(),Estudiante.getEdad(),Estudiante.getCiudad(),Estudiante.getGenero(),Estudiante.getLU())).collect(Collectors.toList());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    //Recuperar un estudiante por su LU
    @Transactional
    public DtoEstudiante findEstudianteByLibrEstudiante(int lu) throws Exception {
        Estudiante resultado = estudianteRepository.getEstudianteByLibrEstudiante(lu);
        try {
            return new DtoEstudiante(resultado.getId_estudiante(), resultado.getNombre(), resultado.getApellido(), resultado.getEdad(), resultado.getCiudad(), resultado.getGenero(), resultado.getLU());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    

}
