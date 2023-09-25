package Interfaces;

import org.springframework.stereotype.Repository;
import Entidades.Carrera;
import java.util.List;

@Repository
public interface InterfaceCarreraRepository {

	List<Carrera> obtenerCarrerasConEstudiantesOrdenadas();

		
}
