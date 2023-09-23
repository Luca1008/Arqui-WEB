package Repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import Entidades.Carrera;
import Entidades.Estudiante;
import Interfaces.InterfaceEstudianteRepo;

@Repository
public class EstudianteRepository implements InterfaceEstudianteRepo {
	EntityManager em;

	public EstudianteRepository() {

	}

	

	public EstudianteRepository(EntityManager em) {
		this.em = em;
	}



	@Override
	public List<Estudiante> listarEstudiantes() {
		return em.createQuery("SELECT e FROM Estudiante e", Estudiante.class).getResultList();
	}

	@Override
	public List<Estudiante> listarEstudiantes(String genero) {
		TypedQuery<Estudiante> query = em.createQuery(
                "SELECT e FROM Estudiante e ORDER BY e.genero", Estudiante.class);
        return query.getResultList();
	}

	@Override
	public Estudiante buscarPorLibreta(int numeroLibreta) {
		return em.createQuery("SELECT e FROM Estudiante e WHERE e.numLibretaUniversitaria = :numeroLibreta", Estudiante.class)
                .setParameter("numeroLibreta", numeroLibreta)
                .getSingleResult();
	}

	@Override
	public Estudiante insertarEstudiante(String DNI, String nombre, String apellido, String edad, String genero,
			String ciudad,
			String LU) {

		Estudiante nuevoEstudiante = new Estudiante();
		nuevoEstudiante.setDNI(DNI);
		nuevoEstudiante.setNombre(nombre);
		nuevoEstudiante.setApellido(apellido);
		nuevoEstudiante.setEdad(edad);
		nuevoEstudiante.setGenero(genero);
		nuevoEstudiante.setCiudad(ciudad);
		nuevoEstudiante.setLibreta_universitaria(LU);

		return nuevoEstudiante;

	}

	@Override
	public List<Estudiante> estudiantesDe(Carrera carrera) {
		TypedQuery<Estudiante> query = em.createQuery(
                "SELECT e FROM Estudiante e " +
                "JOIN e.estudianteCarreras ec " +
                "WHERE ec.carrera.nombre = :nombreCarrera " +
                "ORDER BY e.ciudadResidencia", Estudiante.class);

        query.setParameter("nombreCarrera", carrera);

        return query.getResultList();
	}

}
