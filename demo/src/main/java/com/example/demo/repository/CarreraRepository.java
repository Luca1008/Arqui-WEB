package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Carrera;
import com.example.demo.model.EstudianteCarrera;

public interface CarreraRepository extends JpaRepository<Carrera, Long> {
    // @Query("SELECT c.carrera, COUNT(ec.id_estudiante) AS Cantidad_Inscritos " +
    //         "FROM Carrera c " +
    //         "JOIN EstudianteCarrera ec ON c.id_carrera = ec.id_carrera " +
    //         "GROUP BY c.carrera " +
    //         "ORDER BY Cantidad_Inscritos DESC")
    // List<Carrera> carrerasConInscriptos();

    @Query("SELECT c FROM Carrera c WHERE id_carrera = :id")
    Carrera getCarreraById(Long id);
}
