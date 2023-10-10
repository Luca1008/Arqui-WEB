package com.example.demo.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Carrera;
import com.example.demo.repository.CarreraRepository;
import com.example.demo.dtos.DtoCarrera;
import com.example.demo.dtos.DtoCarreraMod;
import com.example.demo.dtos.DtoEstudiante;
import com.example.demo.dtos.DtoEstudianteMod;
import com.example.demo.model.Estudiante;

import java.util.*;
import java.util.stream.Collectors;

import jakarta.transaction.Transactional;
import lombok.var;

@Service("CarreraServicio")
public class CarreraServicio {

    @Autowired
    private CarreraRepository carreraRepository;

    // Agregar una carrera
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
            return resultados.stream().map(resultado -> new DtoCarrera(resultado[0], resultado[1]))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<DtoCarreraMod> findAllIngresantesAndEgresadosOrd() throws Exception {
        var carreras = carreraRepository.findAllOrderByName();
        List<DtoCarreraMod> resultado = new ArrayList<>();
        try {
            for (Carrera carrera : carreras) {
                List<DtoEstudianteMod> estudiantesPorInsc = new ArrayList<>();
                List<DtoEstudianteMod> estudiantesPorEgreso = new ArrayList<>();
                var inscriptos = carreraRepository.findEstudiantesByInscripcion(carrera.getId_carrera());
                var egresados = carreraRepository.findEstudiantesByEgreso(carrera.getId_carrera());
                
                
                estudiantesPorInsc = inscriptos.stream().map(result -> {
                                                                        Estudiante Estudiante = (Estudiante) result[0];
                                                                        Integer inscripcion = (Integer) result[1];
                                                                        Integer graduacion = (Integer) result[2];
                                                                        return new DtoEstudianteMod(
                                                                            Estudiante.getId_estudiante(),
                                                                            Estudiante.getNombre(),
                                                                            Estudiante.getApellido(),
                                                                            Estudiante.getEdad(),
                                                                            Estudiante.getCiudad(),
                                                                            Estudiante.getGenero(),
                                                                            Estudiante.getLU(),
                                                                            inscripcion,
                                                                            graduacion);})
                                                                            .collect(Collectors.toList());
                estudiantesPorEgreso = egresados.stream().map(result -> {
                                                                        Estudiante Estudiante = (Estudiante) result[0];
                                                                        Integer inscripcion = (Integer) result[1];
                                                                        Integer graduacion = (Integer) result[2];
                                                                        return new DtoEstudianteMod(
                                                                            Estudiante.getId_estudiante(),
                                                                            Estudiante.getNombre(),
                                                                            Estudiante.getApellido(),
                                                                            Estudiante.getEdad(),
                                                                            Estudiante.getCiudad(),
                                                                            Estudiante.getGenero(),
                                                                            Estudiante.getLU(),
                                                                            inscripcion,
                                                                            graduacion);})
                                                                            .collect(Collectors.toList());

                resultado.add(new DtoCarreraMod(carrera.getCarrera(), estudiantesPorInsc, estudiantesPorEgreso));
            }
            return resultado;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }
}
