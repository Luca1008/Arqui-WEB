package Interfaces;


import java.util.List;

import org.springframework.stereotype.Repository;

import Entidades.Carrera;
import Entidades.Estudiante;
import Entidades.EstudianteCarrera;


@Repository
public interface InterfaceEstudianteCarreraRepository  {

	void matricularEstudianteEnCarrera(Long estudianteId, Long carreraId, int antiguedad);

	List<Estudiante> obtenerEstudiantesPorCarreraYCiudad(String nombreCarrera, String ciudadResidencia);




}
