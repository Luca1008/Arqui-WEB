package Interfaces;

import java.util.List;
import Entidades.Carrera;


public interface InterfaceCarreraRepo {
	Carrera insertar_carrera(String id, String carrera, String duracion);
	//f) recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos. //hacerlo desde estudiante carrera7
	List<Carrera> carreraConInscriptos();
		
}
