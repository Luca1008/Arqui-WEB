package Repositories;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Entidades.Carrera;
import Entidades.Estudiante;
import Interfaces.InterfaceCarreraRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import java.util.Comparator;
import java.util.List;


@Repository
public class CarreraRepository implements InterfaceCarreraRepository {

	private EntityManager entityManager;

	public CarreraRepository () {
		
	}

	public CarreraRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    
	public void agragarCarrera(Carrera estudiante) {
		entityManager.persist(estudiante);
	}

	@Override
	public List<Carrera> obtenerCarrerasConEstudiantesOrdenadas() {
	  String jpql = "SELECT c " +
                      "FROM Carrera c " +
                      "WHERE EXISTS (SELECT ec FROM EstudianteCarrera ec WHERE ec.carrera = c)";

        TypedQuery<Carrera> query = entityManager.createQuery(jpql, Carrera.class);
        List<Carrera> carreras = query.getResultList();

        // Puedes ordenar las carreras por la cantidad de inscritos en memoria si es necesario
        carreras.sort(Comparator.comparingInt(c -> obtenerCantidadInscritos(c)));

        return carreras;
    }

    private int obtenerCantidadInscritos(Carrera carrera) {
        String jpql = "SELECT COUNT(ec) FROM EstudianteCarrera ec WHERE ec.carrera = :carrera";
        Long cantidad = entityManager.createQuery(jpql, Long.class)
                .setParameter("carrera", carrera)
                .getSingleResult();
        return cantidad.intValue();
    }


	
	
}

