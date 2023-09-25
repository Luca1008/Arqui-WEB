package repositories;


import java.sql.Timestamp;
import java.util.List;

import dto.DtoCarrera;
import dto.DtoEstudianteCarrera;


public interface EstudianteCarreraRepository {

	void matricularEstudiante(int idEst, int idCarr, Timestamp fechaInsc, Timestamp fechaEgreso);
	List<DtoCarrera> carrerasConInscriptos();
	List<DtoEstudianteCarrera> estudiantesPorCarreraFiltroCiudad(int idCarrera, String ciudad);
	List<Object[]> getInforme();

}
