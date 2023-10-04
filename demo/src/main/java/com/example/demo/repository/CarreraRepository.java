package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Carrera;

public interface CarreraRepository extends JpaRepository<Carrera, Long> {
    // @Query("\"SELECT c, COUNT(ec) AS inscritos FROM Carrera c \" +\r\n" + //
    //         "           \"LEFT JOIN EstudianteCarrera ec ON c.id = ec.carrera.id \" +\r\n" + //
    //         "           \"GROUP BY c \" +\r\n" + //
    //         "           \"ORDER BY inscritos DESC\"")
    // List<Carrera> carrerasConInscriptos();

    @Query("SELECT c FROM Carrera c WHERE id_carrera = :id")
    Carrera getCarreraById(Long id);
}
