package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.dtos.DtoCarrera;
import com.example.demo.model.CarreraEstudiante;
import com.example.demo.model.Estudiante;



public interface EstudianteCarreraRepository extends JpaRepository<CarreraEstudiante, Long> {	
	List<Object[]> getInforme();

	//GET - recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia
	@Query("SELECT e FROM Estudiante e JOIN EstudianteCarrera ec ON ec.estudiante = e.estudianteId JOIN Carrera c ON c.carreraId = ec.carrera  WHERE c.carreraId = :idCarrera AND e.ciudadResidencia = :ciudad")
    List<Estudiante> estudiantesPorCarreraFiltroCiudad(int idCarrera, String ciudad);

	//GET - generar un reporte de las carreras, que para cada carrera incluya información de los inscriptos y egresados por año. Se deben ordenar las carreras alfabéticamente, y presentar los años de manera cronológica
	@Query("SELECT new dto.DtoCarrera (c.carreraId, c.nombre, COUNT(e.estudianteId)) FROM Carrera c JOIN CarreraEstudiante ce ON ce.carrera = c.carreraId JOIN Estudiante e ON ce.estudiante = e.estudianteId GROUP BY c.carreraId ORDER BY c.carreraId ASC")
    List<DtoCarrera> carrerasPorAño();

}
