package Repositories;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import Entidades.Carrera;
import Entidades.Estudiante;
import Entidades.EstudianteCarrera;
import Interfaces.InterfaceEstudianteCarreraRepository;


@Repository
public class EstudianteCarreraRepository implements InterfaceEstudianteCarreraRepository{

	private EntityManager em;

	public EstudianteCarreraRepository() {
		
	}

	public EstudianteCarreraRepository(EntityManager entityManager) {
        this.em = entityManager;
    }

	

	@Override
	public List<Estudiante> obtenerEstudiantesPorCarreraYCiudad(String nombreCarrera, String ciudadResidencia) {
		String jpql = "SELECT e FROM Estudiante e " +
                      "JOIN e.estudiantesCarrera ec " +
                      "JOIN ec.carrera c " +
                      "WHERE c.nombre = :nombreCarrera AND e.ciudadResidencia = :ciudadResidencia";
        return em.createQuery(jpql, Estudiante.class)
                .setParameter("nombreCarrera", nombreCarrera)
                .setParameter("ciudadResidencia", ciudadResidencia)
                .getResultList();
	}

	@Override
	public void matricularEstudianteEnCarrera(Long estudianteId, Long carreraId, int antiguedad) {
		Estudiante estudiante = em.find(Estudiante.class, estudianteId);
        Carrera carrera = em.find(Carrera.class, carreraId);

        EstudianteCarrera estudianteCarrera = new EstudianteCarrera();
        estudianteCarrera.setEstudiante(estudiante);
        estudianteCarrera.setCarrera(carrera);
        estudianteCarrera.setAntiguedad(antiguedad);

        em.persist(estudianteCarrera);
	}
	
	
	
}