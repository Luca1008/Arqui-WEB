package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Estudiante;;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

	@Query("SELECT e FROM Estudiante e ORDER BY :sort ASC")
	public List<Estudiante> findEstudiantesOrdenados(String sort);

	@Query("SELECT e FROM Estudiante e WHERE e.LU = :numeroLibreta")
	public Estudiante estudiantePorLibreta(int numeroLibreta);

	@Query("SELECT e FROM Estudiante e WHERE e.genero = :genero")
	List<Estudiante> findPorGenero(String genero);

}
