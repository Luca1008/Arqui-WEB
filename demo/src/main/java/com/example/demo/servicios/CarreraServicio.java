package com.example.demo.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Carrera;
import com.example.demo.model.Estudiante;
import com.example.demo.repository.CarreraRepository;
import com.example.demo.repository.EstudianteCarreraRepository;

import jakarta.transaction.Transactional;

@Service("CarreraServicio")
public class CarreraServicio {
    @Autowired
    private CarreraRepository carreraRepository;

    @Transactional
    public Carrera save(Carrera Carrera) throws Exception {
        try {
            return carreraRepository.save(Carrera);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


}
