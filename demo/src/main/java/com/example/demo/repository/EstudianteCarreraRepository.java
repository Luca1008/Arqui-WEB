package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.EstudianteCarrera;
import com.example.demo.model.Estudiante;



public interface EstudianteCarreraRepository extends JpaRepository<EstudianteCarrera, Long> {

	// List<Object[]> getInforme();

	//GET - recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia
	@Query("SELECT e FROM Estudiante e JOIN EstudianteCarrera ec ON ec.idEstudianteCarrera.estudianteId = e.id_estudiante JOIN Carrera c ON c.id_carrera = ec.idEstudianteCarrera.carreraId  WHERE c.carrera = :carrera AND e.ciudad = :ciudad")
    List<Estudiante> estudiantesPorCarreraFiltroCiudad(String carrera, String ciudad);

	// //GET - generar un reporte de las carreras, que para cada carrera incluya información de los inscriptos y egresados por año. Se deben ordenar las carreras alfabéticamente, y presentar los años de manera cronológica
	// @Query("SELECT c FROM Carrera c JOIN CarreraEstudiante ce ON ce.carrera = c.id_carrera JOIN Estudiante e ON ce.estudiante = e.id_estudiante GROUP BY c.id_carrera ORDER BY c.id_carrera ASC")
    // List<DtoCarrera> carrerasPorAño();

}
