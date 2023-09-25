package Interfaces;

import java.util.List;
import Entidades.Carrera;
import Entidades.Estudiante;

public interface InterfaceEstudianteRepository {
	
	void altaEstudiante(Estudiante estudiante);

	List<Estudiante> obtenerTodosEstudiantes();

	Estudiante obtenerEstudiantePorLibreta(String numLibretaUniversitaria);

	List<Estudiante> obtenerEstudiantesPorGenero(String genero);
	

}

