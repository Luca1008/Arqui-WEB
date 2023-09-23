package Repositories;


import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import Entidades.Carrera;
import Entidades.Estudiante;
import Entidades.Estudiante_carrera;
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
        Estudiante_carrera estudianteCarrera = new Estudiante_carrera();
		
		// Establece las relaciones con el estudiante y la carrera
        Estudiante_carrera.setEstudiante(e);
        Estudiante_carrera.setCarrera(c);

        String antiguedad = "0";
		// Establece la antigüedad (u otro atributo relevante) en la relación
        Estudiante_carrera.setAntiguedad(antiguedad);

        // Inicia una transacción
        entityManager.getTransaction().begin();

        // Persiste la relación en la base de datos
        entityManager.persist(estudianteCarrera);

        // Confirma la transacción
        entityManager.getTransaction().commit();
		
	}

	@Override
	public Estudiante_carrera insertar(String id, String id_estudiante, String id_carrera, String inscripcion,
			String graduacion, String antiguedad) {
		Estudiante_carrera e = new Estudiante_carrera();
		e.setId(id);
		e.setInscripcion(inscripcion);
		e.setGraduacion(graduacion);
		e.setAntiguedad(antiguedad);
		return e;
	}
	
	
	
}