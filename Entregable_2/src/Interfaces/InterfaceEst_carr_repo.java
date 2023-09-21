package Interfaces;

import Entidades.Carrera;
import Entidades.Estudiante;
import Entidades.Estudiante_carrera;



public interface InterfaceEst_carr_repo{

	Estudiante_carrera insertar(String id, String id_estudiante, String id_carrera, String inscripcion, String graduacion, String antiguedad);
	//b) matricular un estudiante en una carrera 
	void matricularEstudiante(Estudiante e, Carrera c);
}
