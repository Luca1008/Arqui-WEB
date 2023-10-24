package com.example.demo.servicios;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.DtoCarrera;
import com.example.demo.dtos.DtoEstudiante;
import com.example.demo.model.Estudiante;
import com.example.demo.model.EstudianteCarrera;
import com.example.demo.repository.EstudianteCarreraRepository;

import jakarta.transaction.Transactional;

@Service("EstudianteCarreraServicio")
public class EstudianteCarreraServicio {
    @Autowired
    private EstudianteCarreraRepository estudianteCarreraRepository;

    // Matricular estudiante a una carrera
    @Transactional
    public EstudianteCarrera save(EstudianteCarrera estudiante) throws Exception {
        try {
            return estudianteCarreraRepository.save(estudiante);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    // Recuperar todas las matriculaciones
    @Transactional
    public List<EstudianteCarrera> findAll() throws Exception {
        try {
            return estudianteCarreraRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia.
    @Transactional
    public List<DtoEstudiante> findByCarreraFilterCiudad(String carrera, String ciudad) throws Exception {
        var resultado = estudianteCarreraRepository.estudiantesPorCarreraFiltroCiudad(carrera,ciudad);
        try{
            return resultado.stream().map(Estudiante -> new DtoEstudiante(Estudiante.getId_estudiante(),Estudiante.getNombre(),Estudiante.getApellido(),Estudiante.getEdad(),Estudiante.getCiudad(),Estudiante.getGenero(),Estudiante.getLU())).collect(Collectors.toList());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
