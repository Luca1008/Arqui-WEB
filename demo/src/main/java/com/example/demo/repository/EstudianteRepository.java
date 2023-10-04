package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Estudiante;;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

	// @Query("SELECT e FROM Estudiante e ORDER BY :sort ASC")
	// public List<Estudiante> findEstudiantesOrdenados(String sort);

	// @Query("SELECT e FROM Estudiante e WHERE e.LU = :numeroLibreta")
	// public Estudiante estudiantePorLibreta(int numeroLibreta);

	@Query("SELECT e FROM Estudiante e WHERE e.genero = :genero")
	List<Estudiante> findPorGenero(String genero);

	@Query("SELECT e FROM Estudiante e WHERE id_estudiante = :id")
	Estudiante getEstudianteById(Long id);

	@Query("SELECT e FROM Estudiante e WHERE LU = :numero")
	Estudiante getEstudianteByLibrEstudiante(int numero);

	@Query("SELECT e FROM Estudiante e ORDER BY "
		+ "CASE WHEN :columna = 'id_estudiante' THEN e.id_estudiante "
		+ "WHEN :columna = 'nombre' THEN e.nombre "
		+ "WHEN :columna = 'apellido' THEN e.apellido "
		+ "WHEN :columna = 'edad' THEN e.edad "
		+ "WHEN :columna = 'genero' THEN CAST(e.genero AS string) "
		+ "WHEN :columna = 'ciudad' THEN e.ciudad "
		+ "WHEN :columna = 'LU' THEN e.LU "
		+ "WHEN :columna = 'id' THEN e.id_estudiante "
		+ "END ASC")
	public List<Estudiante> findEstudiantesOrdenados(String columna);


}
