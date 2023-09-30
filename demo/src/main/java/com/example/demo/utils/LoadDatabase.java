package com.example.demo.utils;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(@Qualifier("personRepository") EstudianteRepository repository) {
        return args -> {
            /* log.info("Preloading " + repository.save(new Person((long) 1234,"Seba", "Perez")));
            log.info("Preloading " + repository.save(new Person((long) 2345, "Juan", "Dominguez"))); */

            //cargar los diferentes elemnetos a la base de datos

        };
    }
    CommandLineRunner initDatabase(@Qualifier("personRepository") CarreraRepository repository) {
        return args -> {
            /* log.info("Preloading " + repository.save(new Person((long) 1234,"Seba", "Perez")));
            log.info("Preloading " + repository.save(new Person((long) 2345, "Juan", "Dominguez"))); */

            //cargar los diferentes elemnetos a la base de datos

        };
    }
    CommandLineRunner initDatabase(@Qualifier("personRepository") CERepository repository) {
        return args -> {
            /* log.info("Preloading " + repository.save(new Person((long) 1234,"Seba", "Perez")));
            log.info("Preloading " + repository.save(new Person((long) 2345, "Juan", "Dominguez"))); */

            //cargar los diferentes elemnetos a la base de datos

        };
    }
}