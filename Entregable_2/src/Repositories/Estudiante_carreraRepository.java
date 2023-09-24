package Repositories;


import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import Entidades.Carrera;
import Entidades.Estudiante;
import Entidades.EstudianteCarrera;
import Interfaces.InterfaceEst_carr_repo;


@Repository
public class Estudiante_carreraRepository implements InterfaceEst_carr_repo{

	private EntityManager entityManager;

	public Estudiante_carreraRepository() {
		
	}

	public Estudiante_carreraRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

	@Override
	public void matricularEstudiante(Estudiante e, Carrera c) {

		// Crea una nueva instancia de EstudianteCarrera
        EstudianteCarrera estudianteCarrera = new EstudianteCarrera();
		
		// Establece las relaciones con el estudiante y la carrera
        EstudianteCarrera.setEstudiante(e);
        EstudianteCarrera.setCarrera(c);

        String antiguedad = "0";
		// Establece la antigüedad (u otro atributo relevante) en la relación
        EstudianteCarrera.setAntiguedad(antiguedad);

        // Inicia una transacción
        entityManager.getTransaction().begin();

        // Persiste la relación en la base de datos
        entityManager.persist(estudianteCarrera);

        // Confirma la transacción
        entityManager.getTransaction().commit();
		
	}

	@Override
	public EstudianteCarrera insertar(String id, String id_estudiante, String id_carrera, String inscripcion,
			String graduacion, String antiguedad) {
		EstudianteCarrera e = new EstudianteCarrera();
		e.setId(id);
		e.setInscripcion(inscripcion);
		e.setGraduacion(graduacion);
		e.setAntiguedad(antiguedad);
		return e;
	}
	
	
	
}