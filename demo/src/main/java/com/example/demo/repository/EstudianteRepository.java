package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.dtos.DtoEstudiante;
import com.example.demo.model.Estudiante;
;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

	
	
	void altaEstudiante(Estudiante e);
	DtoEstudiante estudiantePorLibreta(int numeroLibreta);
	List<DtoEstudiante> listaPorGenero(String genero);
	List<DtoEstudiante> listaPorApellido();
	
	
	
	
	
	
}
