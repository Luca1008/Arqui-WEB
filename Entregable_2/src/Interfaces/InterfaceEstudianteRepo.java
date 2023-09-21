package Interfaces;

import java.util.List;
import Entidades.Carrera;
import Entidades.Estudiante;

public interface InterfaceEstudianteRepo {
    //c) recuperar todos los estudiantes, y especificar alg�n criterio de ordenamiento simple (por apellido)
	List<Estudiante> listarEstudiantes();
	
	//e) recuperar todos los estudiantes, en base a su g�nero.
	List<Estudiante> listarEstudiantes(String genero);
	
	//d) recuperar un estudiante, en base a su n�mero de libreta universitaria.
	Estudiante buscarPorLibreta(int libreta);
	
	//a) dar de alta un estudiante
	Estudiante insertarEstudiante(String DNI,String nombre, String apellido, String edad, String genero, String ciudad,String LU);
	
	//g) recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia.
	List<Estudiante> estudiantesDe(Carrera carrera);
}

