package com.example.demo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.EstudianteCarrera;
import com.example.demo.repository.EstudianteCarreraRepository;


import jakarta.transaction.Transactional;

@Service("EstudianteCarreraServicio")
public class EstudianteCarreraServicio {
    @Autowired
    private EstudianteCarreraRepository estudianteCarreraRepository;

    @Transactional
    public EstudianteCarrera save(EstudianteCarrera estudiante) throws Exception {
        try {
            return estudianteCarreraRepository.save(estudiante);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<EstudianteCarrera> findAll() throws Exception { 
        try {
            return estudianteCarreraRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
