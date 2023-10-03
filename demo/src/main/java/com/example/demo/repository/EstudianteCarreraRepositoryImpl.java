// package com.example.demo.repository;

// import java.sql.Timestamp;
// import java.util.List;

// import org.springframework.data.jpa.repository.Query;
// import org.springframework.stereotype.Repository;

// import com.example.demo.dtos.DtoCarrera;
// import com.example.demo.dtos.DtoEstudianteCarrera;
// import com.example.demo.model.CarreraEstudiante;


// import jakarta.persistence.EntityManager;

// @Repository("EstudianteCarreraRepositoryImpl")
// public class EstudianteCarreraRepositoryImpl implements EstudianteCarreraRepository {

// 	EntityManager em;

// 	public EstudianteCarreraRepositoryImpl(EntityManager em) {
//         this.em = em;
//     }

// 	@Override
// 	public void matricularEstudiante(CarreraEstudiante e) {
// 		this.em.getTransaction().begin();
// 		em.persist(e);
// 		this.em.getTransaction().commit();

// 	}

// 	public List<DtoCarrera> carrerasConInscriptos() {
		
// 		@SuppressWarnings("unchecked")
// 		List<DtoCarrera> carrerasConInscriptosPorCantInsc = em.createQuery(
// 				"SELECT new dto.DtoCarrera(c.nombre , c.duracion) FROM Carrera c JOIN  c.estudiantes e GROUP BY c ORDER BY COUNT(e) DESC",
// 				DtoCarrera.class).getResultList();
// 		return carrerasConInscriptosPorCantInsc;
// 	}

// 	@Override
// 	public List<DtoEstudianteCarrera> estudiantesPorCarreraFiltroCiudad(int idCarrera, String ciudad) {
// 		@SuppressWarnings("unchecked")
// 		String jpql = "SELECT new dto.DtoEstudianteCarrera (e.nombre, e.apellido, e.ciudadResidencia, c.nombre) FROM Estudiante e "
// 				+ "JOIN EstudianteCarrera ec ON ec.estudiante = e.id_estudiante "
// 				+ "JOIN Carrera c ON c.id_carrera = ec.carrera " + "WHERE e.ciudadResidencia = ?1 AND c.id_carrera = ?2";
// 		List<DtoEstudianteCarrera> dto = em.createQuery(jpql, DtoEstudianteCarrera.class).setParameter(1, ciudad)
// 				.setParameter(2, idCarrera).getResultList();

// 		return dto;
// //		return null;
// 	}

// 	@Override
// 	public List<Object[]> getInforme() {
// 		@SuppressWarnings("unchecked")
// 		List<Object[]> informe = em.createNativeQuery(
// 				"SELECT nombreCarrera, anio, SUM(cantidadInscriptos) AS inscriptos,  SUM(cantidadEgresados) AS egresados "
// 						+ "FROM ("
// 						+ "(SELECT c.nombre AS nombreCarrera, COUNT(ec.estudiante_id) AS cantidadInscriptos, 0 AS cantidadEgresados,EXTRACT(YEAR FROM ec.inscripcion) AS anio "
// 						+ "FROM estudiante_carrera ec JOIN Carrera c on c.carrera_id= ec.carrera_id "
// 						+ "GROUP BY nombreCarrera, anio ) " + "UNION ALL "
// 						+ "(SELECT c1.nombre AS nombreCarrera, 0 AS cantidadInscriptos ,COUNT(ec1.estudiante_id) AS cantidadEgresados, EXTRACT(YEAR FROM ec1.egreso) AS anio "
// 						+ "FROM estudiante_carrera ec1 JOIN Carrera c1 on c1.carrera_id=ec1.carrera_id "
// 						+ "GROUP BY nombreCarrera, anio ) )s " + "WHERE anio IS NOT NULL "
// 						+ "GROUP BY nombreCarrera, anio " + "ORDER BY nombreCarrera ,anio")
// 				.getResultList();
// 		return informe;
// 	}



// }
	

