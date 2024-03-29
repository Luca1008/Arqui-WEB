package com.example.demo.utils;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

@Configuration
public class LoadDatabase {

    private final CarreraRepository CarreraRepository;
    private final EstudianteCarreraRepository EstudianteCarreraRepository;
    private final EstudianteRepository EstudianteRepository;

    @Autowired
    public LoadDatabase(CarreraRepository CarreraRepository,
            EstudianteCarreraRepository EstudianteCarreraRepository,
            EstudianteRepository EstudianteRepository) {

        this.CarreraRepository = CarreraRepository;
        this.EstudianteCarreraRepository = EstudianteCarreraRepository;
        this.EstudianteRepository = EstudianteRepository;
    }

    public void initDatabase() throws IOException {
        // cargar los diferentes elemnetos a la base de datos
        File archivoCSVEstudiante = ResourceUtils.getFile("src/main/java/com/example/demo/csv/estudiantes.csv");
        File archivoCSVCarrera = ResourceUtils.getFile("src/main/java/com/example/demo/csv/carreras.csv");
        File archivoCSVEstudianteCarrera = ResourceUtils
                .getFile("src/main/java/com/example/demo/csv/estudianteCarrera.csv");

        try (FileReader reader = new FileReader(archivoCSVEstudiante);
                CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {

            for (CSVRecord csvRecord : csvParser) {
                Estudiante estudiante = new Estudiante();
                estudiante.setId_estudiante(Long.valueOf(csvRecord.get("id_estudiante")));
                estudiante.setNombre(csvRecord.get("nombre"));
                estudiante.setApellido(csvRecord.get("apellido"));
                estudiante.setEdad(Integer.parseInt(csvRecord.get("edad")));
                estudiante.setGenero(csvRecord.get("genero"));
                estudiante.setCiudad(csvRecord.get("ciudad"));
                estudiante.setLU(Integer.parseInt(csvRecord.get("LU")));
                EstudianteRepository.save(estudiante);
            }
        }
        try (FileReader reader = new FileReader(archivoCSVCarrera);
                CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {

            for (CSVRecord csvRecord : csvParser) {
                Carrera carrera = new Carrera();
                carrera.setCarrera(csvRecord.get("carrera"));
                carrera.setDuracion(Integer.parseInt(csvRecord.get("duracion")));
                CarreraRepository.save(carrera);
            }
        }
        try (FileReader reader = new FileReader(archivoCSVEstudianteCarrera);
                CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {

            for (CSVRecord csvRecord : csvParser) {
                EstudianteCarrera CE = new EstudianteCarrera();
                Long i= Long.valueOf(csvRecord.get("id_estudiante"));
                Long o=Long.valueOf(csvRecord.get("id_carrera"));
                int p=Integer.parseInt(csvRecord.get("inscripcion"));
                int l=Integer.parseInt(csvRecord.get("graduacion"));
                int k=Integer.parseInt(csvRecord.get("antiguedad"));
                CE.setEstudiante(EstudianteRepository.getEstudianteById(i));
                CE.setCarrera(CarreraRepository.getCarreraById(o));
                CE.setInscripcion(p);
                CE.setGraduacion(l);
                CE.setAntiguedad(k);
                EstudianteCarreraRepository.save(CE);
            }
        }

    };

}