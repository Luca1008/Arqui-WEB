package com.example.demo.repository;


import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dtos.DtoCarrera;
import com.example.demo.dtos.DtoEstudianteCarrera;
import com.example.demo.model.CarreraEstudiante;



public interface EstudianteCarreraRepository extends JpaRepository<CarreraEstudiante, Long> {


	

	void matricularEstudiante(CarreraEstudiante e);
	List<DtoCarrera> carrerasConInscriptos();
	List<DtoEstudianteCarrera> estudiantesPorCarreraFiltroCiudad(int idCarrera, String ciudad);
	List<Object[]> getInforme();

}
