package Repositories;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import Entidades.Carrera;
import Interfaces.InterfaceCarreraRepo;


@Repository
public class CarreraRepository implements InterfaceCarreraRepo {

	private EntityManager entityManager;

	public CarreraRepository () {
		
	}

	public CarreraRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
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
		TypedQuery<Carrera> query = entityManager.createQuery(
                "SELECT c FROM Carrera c " +
                "JOIN FETCH c.estudianteCarreras ec " +
                "GROUP BY c " +
                "ORDER BY COUNT(ec) DESC", Carrera.class);

        return query.getResultList();
	} //ACA HACER LO DE TEST ESTUDIANTES PERO EN CADA TABLA
	
}

