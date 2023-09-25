package Repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Entidades.Carrera;
import Entidades.Estudiante;
import Interfaces.InterfaceEstudianteRepository;

@Repository
public class EstudianteRepository implements InterfaceEstudianteRepository {
	EntityManager em;

	private EstudianteRepository() {

	}

	private EstudianteRepository(EntityManager em) {
		this.em = em;
	}



	@Override
	public void altaEstudiante(Estudiante estudiante) {
		em.persist(estudiante);
	}

	@Override
	public List<Estudiante> obtenerTodosEstudiantes() {
		String jpql = "SELECT e FROM Estudiante e";
        return em.createQuery(jpql, Estudiante.class)
                .getResultList();
	}

	@Override
	public Estudiante obtenerEstudiantePorLibreta(String numLibretaUniversitaria) {
		String jpql = "SELECT e FROM Estudiante e WHERE e.numLibretaUniversitaria = :numLibreta";
        return em.createQuery(jpql, Estudiante.class)
                .setParameter("numLibreta", numLibretaUniversitaria)
                .getSingleResult();
	}

	@Override
	public List<Estudiante> obtenerEstudiantesPorGenero(String genero) {
		String jpql = "SELECT e FROM Estudiante e WHERE e.genero = :genero";
        return em.createQuery(jpql, Estudiante.class)
                .setParameter("genero", genero)
                .getResultList();
	}


}
