package com.example.demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Carrera;

public interface CarreraRepository extends JpaRepository<Carrera, Long>{
	
	@Query("SELECT c, COUNT(ec) FROM Carrera c JOIN c.estudianteCarrera ec GROUP BY c ORDER BY COUNT(ec) DESC")
    List<Carrera> carrerasConInscriptos();
}
