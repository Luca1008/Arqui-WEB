package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Estudiante;;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

	//Recuperar por genero
	@Query("SELECT e FROM Estudiante e WHERE e.genero = :genero")
	List<Estudiante> findPorGenero(String genero);


	//Recuperar por id
	@Query("SELECT e FROM Estudiante e WHERE id_estudiante = :id")
	Estudiante getEstudianteById(Long id);


	//Recuperrar por numero de libreta
	@Query("SELECT e FROM Estudiante e WHERE LU = :numero")
	Estudiante getEstudianteByLibrEstudiante(int numero);


	//Recuperar indicando el metodo de ordenamiento 
	@Query("SELECT e FROM Estudiante e ORDER BY "
           + "CASE WHEN :columna = 'id_estudiante' THEN e.id_estudiante END ASC, "
           + "CASE WHEN :columna = 'nombre' THEN e.nombre END ASC, "
           + "CASE WHEN :columna = 'apellido' THEN e.apellido END ASC, "
           + "CASE WHEN :columna = 'edad' THEN e.edad END ASC, "
           + "CASE WHEN :columna = 'genero' THEN e.genero END ASC, "
           + "CASE WHEN :columna = 'ciudad' THEN e.ciudad END ASC, "
           + "CASE WHEN :columna = 'LU' THEN e.LU END ASC")
	List<Estudiante> findEstudiantesOrdenados(String columna);


}
