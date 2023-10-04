package com.example.demo.servicios;

import java.util.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Estudiante;
import com.example.demo.repository.EstudianteRepository;

import jakarta.transaction.Transactional;

@Service("EstudianteServicio")
public class EstudianteServicio {
    @Autowired
    private EstudianteRepository estudianteRepository;

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
    public Estudiante findById(Long id) throws Exception {
        try {
            Optional<Estudiante> result = estudianteRepository.findById(id);
            return result.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<Estudiante> findAll() throws Exception {
        return estudianteRepository.findAll();
    }

    //GET - findByGenero
    @Transactional
    public List<Estudiante> findByGenero(String genero) throws Exception{
        try {
            return estudianteRepository.findPorGenero(genero);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<Estudiante> findEstudiantesOrdenados(String sort) throws Exception {
        try {
            return estudianteRepository.findEstudiantesOrdenados(sort);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public Estudiante findEstudianteByLibrEstudiante(int lu) throws Exception {
        try {
            return estudianteRepository.getEstudianteByLibrEstudiante(lu);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    

}
