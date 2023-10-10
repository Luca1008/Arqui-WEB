package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.demo.model.*;
import com.example.demo.dtos.DtoCarrera;

public interface CarreraRepository extends JpaRepository<Carrera, Long> {


    @Query("SELECT c FROM Carrera c ORDER BY c.carrera ASC")
    public List<Carrera> findAllOrderByName();

    @Query("SELECT c.carrera, COUNT(ec) FROM Carrera c LEFT JOIN c.estudianteCarrera ec GROUP BY c.carrera ORDER BY COUNT(ec) DESC")
    public List<Object[]> findAllCarrerasCantInscriptos();

    //Recuperar por id
    @Query("SELECT c FROM Carrera c WHERE id_carrera = :id")
    Carrera getCarreraById(Long id);

    @Query("SELECT e, ec.inscripcion, ec.graduacion FROM Estudiante e\r\n" + //
            "JOIN e.estudianteCarreras ec\r\n" + //
            "JOIN ec.carrera c\r\n" + //
            "WHERE c.id_carrera = :id_carrera\r\n" + //
            "AND ec.inscripcion > 0\r\n" + //
            "ORDER BY ec.inscripcion ASC")
    public List<Object[]> findEstudiantesByInscripcion(Long id_carrera);

    @Query("SELECT e, ec.inscripcion, ec.graduacion  FROM Estudiante e\r\n" + //
            "JOIN e.estudianteCarreras ec\r\n" + //
            "JOIN ec.carrera c\r\n" + //
            "WHERE c.id_carrera = :id_carrera\r\n" + //
            "AND ec.graduacion > 0\r\n" + //
            "ORDER BY ec.graduacion ASC")
    public List<Object[]> findEstudiantesByEgreso(Long id_carrera);
}
