package Repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import Entidades.Carrera;
import Entidades.Estudiante;
import Interfaces.InterfaceEstudianteRepo;

@Repository
public class EstudianteRepository implements InterfaceEstudianteRepo {
	public EstudianteRepository() {
		
	}

	

	@Override
	public List<Estudiante> listarEstudiantes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Estudiante> listarEstudiantes(String genero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Estudiante buscarPorLibreta(int libreta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Estudiante insertarEstudiante(String DNI, String nombre, String apellido, String edad, String genero, String ciudad,
			String LU) {
		
		Estudiante nuevoEstudiante = new Estudiante();
		nuevoEstudiante.setDNI(DNI);
		nuevoEstudiante.setNombre(nombre);
		nuevoEstudiante.setApellido(apellido);
		nuevoEstudiante.setEdad(edad);
		nuevoEstudiante.setGenero(genero);
		nuevoEstudiante.setCiudad(ciudad);
		nuevoEstudiante.setLibreta_universitaria(LU);
		
		return nuevoEstudiante;
		
		
		
	}

	@Override
	public List<Estudiante> estudiantesDe(Carrera carrera) {
		// TODO Auto-generated method stub
		return null;
	}


	
	

}
