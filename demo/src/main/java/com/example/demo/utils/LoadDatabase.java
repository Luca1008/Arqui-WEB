package com.example.demo.utils;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(@Qualifier("EstudianteRepository") EstudianteRepository EstudianteRepository) {
        return args -> {
            //cargar los diferentes elemnetos a la base de datos
            File archivoCSV = ResourceUtils.getFile("src/main/java/com/example/demo/csv/estudiante.csv");

            try (FileReader reader = new FileReader(archivoCSV);
                CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {

                for (CSVRecord csvRecord : csvParser) {
                    Estudiante estudiante = new Estudiante();
                    estudiante.setDni(Integer.parseInt(csvRecord.get("DNI")));
                    estudiante.setNombre(csvRecord.get("nombre"));
                    estudiante.setApellido(csvRecord.get("apellido"));
                    estudiante.setEdad(Integer.parseInt(csvRecord.get("edad")));
                    estudiante.setGenero(csvRecord.get("genero"));
                    estudiante.setCiudad(csvRecord.get("ciudad"));
                    estudiante.setNumeroLibreta(Integer.parseInt(csvRecord.get("numeroLibreta")));
                    Log.info("Preloading" + EstudianteRepository.save(estudiante)); // Guarda el perro en la base de datos
                }
            }

        };
    }
    CommandLineRunner initDatabase(@Qualifier("CarreraRepository") CarreraRepository CarreraRepository) {
        return args -> {

            //cargar los diferentes elemnetos a la base de datos
            File archivoCSV = ResourceUtils.getFile("src/main/java/com/example/demo/csv/carrera.csv");

            try (FileReader reader = new FileReader(archivoCSV);
                CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {

                for (CSVRecord csvRecord : csvParser) {
                    Carrera carrera = new Carrera();
                    carrera.setNombre(csvRecord.get("nombre"));
                    carrera.setDuracion(Integer.parseInt(csvRecord.get("duracion")));
                    Log.info("Preloading" + CarreraRepository.save(carrera)); // Guarda el perro en la base de datos
                }
            }

        };
    }
    CommandLineRunner initDatabase(@Qualifier("personRepository") CERepository repository) {
        return args -> {
            /* log.info("Preloading " + repository.save(new Person((long) 1234,"Seba", "Perez")));
            log.info("Preloading " + repository.save(new Person((long) 2345, "Juan", "Dominguez"))); */

            //cargar los diferentes elemnetos a la base de datos
            File archivoCSV = ResourceUtils.getFile("src/main/java/com/example/demo/csv/estudiante.csv");

            try (FileReader reader = new FileReader(archivoCSV);
                CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {

                for (CSVRecord csvRecord : csvParser) {
                    Estudiante estudiante = new Estudiante();
                    estudiante.setNombre(csvRecord.get("nombre"));
                    estudiante.setRaza(csvRecord.get("raza"));
                    estudiante.setEdad(Integer.parseInt(csvRecord.get("edad")));
                    estudiante.setHabilidad(csvRecord.get("habilidad"));
                    Log.info("Preloading" + EstudianteRepository.save(estudiante)); // Guarda el perro en la base de datos
                }
            }

        };
    }
}