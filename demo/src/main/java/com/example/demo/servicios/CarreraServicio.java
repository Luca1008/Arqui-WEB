package com.example.demo.servicios;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Carrera;
import com.example.demo.repository.CarreraRepository;
import com.example.demo.dtos.DtoCarrera;
import java.util.*;
import java.util.stream.Collectors;

import jakarta.transaction.Transactional;
import lombok.var;

@Service("CarreraServicio")
public class CarreraServicio {

    @Autowired
    private CarreraRepository carreraRepository;


    //Agregar una carrera
    @Transactional
    public Carrera save(Carrera Carrera) throws Exception {
        try {
            return carreraRepository.save(Carrera);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<DtoCarrera> findAllCarrerasCantInscriptos() throws Exception {
        var resultados = carreraRepository.findAllCarrerasCantInscriptos();
        try {
            return resultados.stream().map(resultado -> new DtoCarrera(resultado[0], resultado[1])).collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


}
