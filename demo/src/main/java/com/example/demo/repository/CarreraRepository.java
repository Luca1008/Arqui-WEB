package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.demo.model.*;
import com.example.demo.dtos.DtoCarrera;


public interface CarreraRepository extends JpaRepository<Carrera, Long> {


    // @Query("SELECT c.carrera, COUNT(ec.id_estudiante) AS Cantidad_Inscritos " +
    //         "FROM Carrera c " +
    //         "JOIN EstudianteCarrera ec ON c.id_carrera = ec.id_carrera " +
    //         "GROUP BY c.carrera " +
    //         "ORDER BY Cantidad_Inscritos DESC")
    // L
    
    // recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos
    //@Query("SELECT FROM Carrera c LEFT JOIN c.estudianteCarrera ec GROUP BY c.nombre ORDER BY COUNT(ec) DESC")
    //public List<Carrera> findAllCarrerasCantInscriptos();
    @Query("SELECT c.carrera, COUNT(ec) FROM Carrera c LEFT JOIN c.estudianteCarrera ec GROUP BY c.carrera ORDER BY COUNT(ec) DESC")
    public List<Object[]> findAllCarrerasCantInscriptos();


    //@Query("SELECT c FROM Carrera c JOIN FETCH c.Estudiante e GROUP BY c.id ORDER BY COUNT(e) DESC")
    // public List<DtoCarrera> findCarrerasConEstudiantesOrdenadasPorInscritos();


    //Recuperar por id
    @Query("SELECT c FROM Carrera c WHERE id_carrera = :id")
    Carrera getCarreraById(Long id);
}
