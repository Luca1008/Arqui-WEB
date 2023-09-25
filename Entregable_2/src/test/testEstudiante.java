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
import Entidades.EstudianteCarrera;
import Repositories.CarreraRepository;
import Repositories.EstudianteRepository;
import Repositories.EstudianteCarreraRepository;


public class testEstudiante {

	public static final String ESTUDIANTES_FILE = "Entregable_2\\src\\Entidades\\Carrera.java";
	public static final String CARRERAS_FILE= "Entregable_2\\src\\dataset\\estudianteCarrera.csv";
	public static final String ESTUDIANTE_CARRERA_FILE= "Entregable_2\\src\\dataset\\estudianteCarrera.csv";
	public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Entregable2");
	public static final EntityManager em = emf.createEntityManager();


	public static void main(String[] args) throws FileNotFoundException, SQLException, IOException {
	
		try {
			em.getTransaction().begin();

			// Llamar a los métodos para realizar consultas
			EstudianteRepository estudianteRepository = new EstudianteRepository();
			CarreraRepository carreraRepository = new CarreraRepository();
			EstudianteCarreraRepository estudianteCarreraRepository = new EstudianteCarreraRepository();
	
			// Llamar a los métodos para insertar datos
			insertarEstudiantes(estudianteRepository);
			insertarCarreras(carreraRepository);
			insertarEstudiantesCarreras(estudianteCarreraRepository);
	
			
	
			// Consultas y pruebas de otros métodos aquí
			// Ejemplo: List<Estudiante> estudiantes = estudianteRepository.obtenerTodosEstudiantes();
			@SuppressWarnings("unchecked")
			List<Estudiante> estudiantes = estudianteRepository.obtenerTodosEstudiantes();
			System.out.println("En esta base de datos hay "+ estudiantes.size()+ " estudiantes");
	
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
	}
	
		public static void insertarEstudiantes(EstudianteRepository estudianteRepository) throws SQLException, FileNotFoundException, IOException {
			// Código para insertar estudiantes desde el archivo CSV
			File estudiantes =new File(ESTUDIANTES_FILE);
			String apellido,nombre,genero,ciudad,libreta_universitaria,numDocumento;
			int edad;
			boolean graduado = false;

			CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(estudiantes));
			for (CSVRecord record : parser) {
				numDocumento = record.get("numDocumento");
				nombre = record.get("nombre");
				apellido = record.get("apellido");
                edad = Integer.parseInt(record.get("edad"));
				genero = record.get("genero");
				ciudad = record.get("ciudad");
                libreta_universitaria = record.get("libreta_universitaria");
                Estudiante estudiante = new Estudiante(nombre,apellido,edad,genero,numDocumento,ciudad,libreta_universitaria,graduado);
                estudianteRepository.altaEstudiante(estudiante);
            }
		}
	
		public static void insertarCarreras(CarreraRepository carreraRepository) throws SQLException, FileNotFoundException, IOException {
			// Código para insertar carreras desde el archivo CSV
			File carreras =new File(CARRERAS_FILE);
			String nombreCarrera;
			int duracion;

			CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(carreras));

			for(CSVRecord record: parser) {
				nombreCarrera=(record.get("carrera"));
				duracion=Integer.parseInt(record.get("duracion"));
				Carrera c= new Carrera(nombreCarrera, duracion);
				carreraRepository.agragarCarrera(c);

			}
		}
	
		public static void insertarEstudiantesCarreras(EstudianteCarreraRepository estudianteCarreraRepository) throws SQLException, FileNotFoundException, IOException {
			// Código para insertar relaciones Estudiante-Carrera desde el archivo CSV
			File estudiantes_carreras =new File(ESTUDIANTE_CARRERA_FILE);
			CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(estudiantes_carreras));
			Long id, id_estudiante, id_carrera;
			int antiguedad,inscripcion,graduacion;


		
		for(CSVRecord row: parser) {
			id=Long.parseLong(row.get("id"));
			id_estudiante=Long.parseLong(row.get("id_estudiante"));
			id_carrera=Long.parseLong(row.get("id_carrera"));
			inscripcion=Integer.parseInt(row.get("inscripcion"));
			graduacion=Integer.parseInt(row.get("graduacion"));
			antiguedad=Integer.parseInt(row.get("antiguedad"));
			EstudianteCarrera e = new EstudianteCarrera(id, id_estudiante,id_carrera,antiguedad,graduacion,inscripcion);
			EstudianteCarreraRepository.agragarEstudianteCarrera(e);
			
		}
	}

}
