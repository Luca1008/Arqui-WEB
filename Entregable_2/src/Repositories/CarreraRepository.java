package Repositories;


import java.util.List;
import org.springframework.stereotype.Repository;
import Entidades.Carrera;
import Interfaces.InterfaceCarreraRepo;


@Repository
public class CarreraRepository implements InterfaceCarreraRepo {

	public CarreraRepository () {
		
	}
	@Override
	public Carrera insertar_carrera(String id, String carrera, String duracion) {
		Carrera nuevaCarrera = new Carrera();
		nuevaCarrera.setId_carrera(id);
		nuevaCarrera.setCarrera(carrera);
		nuevaCarrera.setDuracion(duracion);
		return nuevaCarrera;
		
		
	}

	@Override
	public List<Carrera> carreraConInscriptos() {
		// TODO Auto-generated method stub
		return null;
	} //ACA HACER LO DE TEST ESTUDIANTES PERO EN CADA TABLA
	
}

