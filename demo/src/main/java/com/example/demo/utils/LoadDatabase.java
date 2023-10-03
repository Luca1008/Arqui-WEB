package com.example.demo.utils;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

@Configuration
public class LoadDatabase {

    private final CarreraRepositoryImpl CarreraRepository;
    private final EstudianteCarreraRepositoryImpl EstudianteCarreraRepository;
    private final EstudianteRepositoryImpl EstudianteRepository;

    @Autowired
    public LoadDatabase(CarreraRepositoryImpl CarreraRepository,
            EstudianteCarreraRepositoryImpl EstudianteCarreraRepository,
            EstudianteRepositoryImpl EstudianteRepository) {
        this.CarreraRepository = CarreraRepository;
        this.EstudianteCarreraRepository = EstudianteCarreraRepository;
        this.EstudianteRepository = EstudianteRepository;
    }

    public void initDatabase() throws IOException {
        // cargar los diferentes elemnetos a la base de datos
        File archivoCSVEstudiante = ResourceUtils.getFile("src/main/java/com/example/demo/csv/estudiante.csv");
        File archivoCSVCarrera = ResourceUtils.getFile("src/main/java/com/example/demo/csv/carrera.csv");
        File archivoCSVEstudianteCarrera = ResourceUtils
                .getFile("src/main/java/com/example/demo/csv/estudianteCarrera.csv");

        try (FileReader reader = new FileReader(archivoCSVEstudiante);
                CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {

            for (CSVRecord csvRecord : csvParser) {
                Estudiante estudiante = new Estudiante();
                estudiante.setDni(Integer.parseInt(csvRecord.get("DNI")));
                estudiante.setNombre(csvRecord.get("nombre"));
                estudiante.setApellido(csvRecord.get("apellido"));
                estudiante.setEdad(Integer.parseInt(csvRecord.get("edad")));
                estudiante.setGenero(csvRecord.get("genero"));
                estudiante.setCiudad(csvRecord.get("ciudad"));
                estudiante.setLU(Integer.parseInt(csvRecord.get("numeroLibreta")));
                EstudianteRepository.save(estudiante);
            }
        }
        try (FileReader reader = new FileReader(archivoCSVCarrera);
                CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {

            for (CSVRecord csvRecord : csvParser) {
                Carrera carrera = new Carrera();
                carrera.setNombre(csvRecord.get("nombre"));
                carrera.setDuracion(Integer.parseInt(csvRecord.get("duracion")));
                CarreraRepository.save(carrera);
            }
        }
        try (FileReader reader = new FileReader(archivoCSVEstudianteCarrera);
                CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {

            for (CSVRecord csvRecord : csvParser) {
                CarreraEstudiante CE = new CarreraEstudiante();
                CE.setCarrera(Integer.parseInt(csvRecord.get("idCarrera")));
                CE.setEstudiante(Integer.parseInt(csvRecord.get("idEstudiante")));
                CE.setInscripcion(Timestamp.valueOf(csvRecord.get("fechaInscripcion")));
                CE.setEgreso(Timestamp.valueOf(csvRecord.get("fechaEgreso")));
                EstudianteCarreraRepository.save(CE);
            }
        }

    };

}