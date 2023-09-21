package Repositories;


import org.springframework.stereotype.Repository;
import Entidades.Carrera;
import Entidades.Estudiante;
import Entidades.Estudiante_carrera;
import Interfaces.InterfaceEst_carr_repo;


@Repository
public class Estudiante_carreraRepository implements InterfaceEst_carr_repo{

	public Estudiante_carreraRepository() {
		
	}
	@Override
	public void matricularEstudiante(Estudiante e, Carrera c) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Estudiante_carrera insertar(String id, String id_estudiante, String id_carrera, String inscripcion,
			String graduacion, String antiguedad) {
		Estudiante_carrera e = new Estudiante_carrera();
		e.setId(id);
		e.setInscripcion(inscripcion);
		e.setGraduacion(graduacion);
		e.setAntiguedad(antiguedad);
		return e;
	}
	
	
	
}