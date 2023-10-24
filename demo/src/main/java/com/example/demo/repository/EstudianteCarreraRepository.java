package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.EstudianteCarrera;
import com.example.demo.model.Estudiante;



public interface EstudianteCarreraRepository extends JpaRepository<EstudianteCarrera, Long> {

	// List<Object[]> getInforme();

	//GET - recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia
	@Query("SELECT e FROM Estudiante e JOIN e.estudianteCarreras ec JOIN ec.carrera c WHERE c.carrera = :carrera AND e.ciudad = :ciudad")
    List<Estudiante> estudiantesPorCarreraFiltroCiudad(String carrera, String ciudad);


}
