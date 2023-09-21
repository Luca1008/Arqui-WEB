package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import Entidades.Carrera;
import Entidades.Estudiante;
import Entidades.Estudiante_carrera;
import Repositories.CarreraRepository;
import Repositories.EstudianteRepository;
import Repositories.Estudiante_carreraRepository;


public class testEstudiante {
	public static final String ESTUDIANTES_FILE = ".\\src\\dataset\\estudiantes.csv";
	public static final String CARRERAS_FILE= ".\\src\\dataset\\carreras.csv";
	public static final String ESTUDIANTE_CARRERA_FILE= ".\\src\\dataset\\estudiante_carrera.csv";
	public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Entregable2");
	public static final EntityManager em = emf.createEntityManager();

	public static void main(String[] args) throws FileNotFoundException, SQLException, IOException {
		
		em.getTransaction().begin();
		
		
		
		insertar();
		
	
		@SuppressWarnings("unchecked")
		List<Estudiante> estudiantes = em.createQuery("FROM Estudiante e").getResultList();
		System.out.println("En esta base de datos hay "+ estudiantes.size()+ " estudiantes");
		em.getTransaction().commit();
		em.close();
		emf.close();

	}
	public static void insertar() throws SQLException, FileNotFoundException, IOException{
		CarreraRepository carrera = new CarreraRepository();
		EstudianteRepository estudiante = new EstudianteRepository();
		Estudiante_carreraRepository estudiante_carrera = new Estudiante_carreraRepository();
		
		
		File estudiantes =new File(ESTUDIANTES_FILE);
		File carreras =new File(CARRERAS_FILE);
		File estudiantes_carreras =new File(ESTUDIANTE_CARRERA_FILE);
		
		
		String apellido,edad,nombre,genero,ciudad,libreta_universitaria,id, duracion,id_estudiante,id_carrera,inscripcion,antiguedad,graduacion;
		
		CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(estudiantes));
		
		for(CSVRecord row: parser) {
			id=(row.get("DNI"));
			nombre=(row.get("nombre"));
			apellido=(row.get("apellido"));
			edad=(row.get("edad"));
			genero=(row.get("genero"));
			ciudad=(row.get("ciudad"));
			libreta_universitaria=(row.get("LU"));
			Estudiante e = new Estudiante();
			e =estudiante.insertarEstudiante(id, nombre,apellido, edad,genero,ciudad,libreta_universitaria);
			em.persist(e);
		}
		
		parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(carreras));
		for(CSVRecord row: parser) {
			id=(row.get("id_carrera"));
			nombre=(row.get("carrera"));
			duracion=(row.get("duracion"));
			Carrera c= new Carrera();
			c=carrera.insertar_carrera(id,nombre, duracion);
			em.persist(c);
		}
		/*parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(estudiantes_carreras));
		for(CSVRecord row: parser) {
			id=(row.get("id"));
			id_estudiante=(row.get("id_estudiante"));
			id_carrera=(row.get("id_carrera"));
			inscripcion=(row.get("inscripcion"));
			graduacion=(row.get("graduacion"));
			antiguedad=(row.get("antiguedad"));
			Estudiante_carrera e = new Estudiante_carrera();
			e=estudiante_carrera.insertar(id, id_estudiante, id_carrera,inscripcion,graduacion,antiguedad);
			em.persist(e);
		}*/
		
	}

}
