package main;

import java.io.FileReader;

import javax.persistence.EntityManager;
import dto.DtoCarrera;
import dto.DtoEstudiante;
import dto.DtoEstudianteCarrera;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import factory.FactoryEntityManager;
import entities.Estudiante;
import entities.Carrera;
import repositories.CarreraRepositoryImpl;
import repositories.EstudianteCarreraRepositoryImpl;
import repositories.EstudianteRepositoryImpl;

public class Main {

	public static void main(String[] args) throws SQLException, IOException {
		EntityManager em = FactoryEntityManager.getInstance();

		// crear estudiantes
		
		EstudianteRepositoryImpl eri = new EstudianteRepositoryImpl(em);
		
		Estudiante Florencia = new Estudiante(42029601, "Florencia", "Prat", 24, "fem", "Tandil", 778811);
		Estudiante Leandro = new Estudiante(40942246, "Leandro", "Molina", 25, "masc", "Tandil", 917235);
		Estudiante Jose = new Estudiante(23768567, "Jose", "Rodriguez", 26, "masc", "Azul", 917265);
		Estudiante Martina = new Estudiante(34561524, "Martina", "Perez", 20, "fem", "Azul", 882291);
		Estudiante Pedro = new Estudiante(28915567, "Pedro", "Perez", 40, "masc", "Necochea", 552167);
		Estudiante Lucia = new Estudiante(41552637, "Lucia", "Sol", 33, "fem", "Azul", 992162);
		Estudiante Juan = new Estudiante(22514389, "Juan", "Torres", 18, "masc", "Tandil", 415267);
		Estudiante Santiago = new Estudiante(30772912, "Santiago", "Prat", 21, "masc", "La plata", 127819);
		Estudiante Mariana = new Estudiante(40442662, "Mariana", "Perovich", 45, "fem", "Rauch", 128167);
		Estudiante Fernando = new Estudiante(11455267, "Fernando", "Carrizo", 23, "masc", "Azul", 127627);
				
//		Dar de alta un estudiante
		
		eri.altaEstudiante(Florencia);
		eri.altaEstudiante(Leandro);
		eri.altaEstudiante(Jose);
		eri.altaEstudiante(Martina);
		eri.altaEstudiante(Pedro);
		eri.altaEstudiante(Lucia);
		eri.altaEstudiante(Juan);
		eri.altaEstudiante(Santiago);
		eri.altaEstudiante(Mariana);
		eri.altaEstudiante(Fernando);

		// crear las carreras
		
		Carrera tudai = new Carrera("Tudai", 2);
		Carrera abogacia = new Carrera("Abogacia", 5);
		Carrera sistemas = new Carrera("Sistemas", 5);
		Carrera contador = new Carrera("Contador", 4);
		Carrera medicina = new Carrera("Medicina", 10);
		Carrera veterinaria = new Carrera("Veterinaria", 6);
		Carrera arte = new Carrera("Arte",4);

		// insertar carreras
		
		CarreraRepositoryImpl repoCarrera = new CarreraRepositoryImpl(em);
		
		repoCarrera.insertarCarrera(tudai);
		repoCarrera.insertarCarrera(abogacia);
		repoCarrera.insertarCarrera(sistemas);
		repoCarrera.insertarCarrera(contador);
		repoCarrera.insertarCarrera(medicina);
		repoCarrera.insertarCarrera(veterinaria);

//		Matricular estudiante en una carrera

		EstudianteCarreraRepositoryImpl repoEstCarrera = new EstudianteCarreraRepositoryImpl(em);		
		// creacion fechas inscripcion
		Timestamp insc1 = new Timestamp(System.currentTimeMillis());
		Timestamp insc2 = Timestamp.valueOf("2020-05-10 10:10:10.0");
		Timestamp insc3 = Timestamp.valueOf("2021-05-10 10:10:10.0");
		Timestamp insc4 = Timestamp.valueOf("2022-08-10 10:10:10.0");
		Timestamp insc5 = Timestamp.valueOf("2019-09-10 10:10:10.0");

		// creacion fecha de egreso
		Timestamp grad1 = Timestamp.valueOf("2022-07-23 10:10:10.0");
		Timestamp grad2 = Timestamp.valueOf("2021-04-23 10:10:10.0");
		Timestamp grad3 = Timestamp.valueOf("2019-08-23 10:10:10.0");
		Timestamp grad4 = Timestamp.valueOf("2020-08-23 10:10:10.0");
		
		repoEstCarrera.matricularEstudiante(1, 1, insc2, grad4);
		repoEstCarrera.matricularEstudiante(1, 2, insc1,grad2 );
		repoEstCarrera.matricularEstudiante(2, 1, insc3, grad3);
		repoEstCarrera.matricularEstudiante(3, 1, insc1, null);	
		repoEstCarrera.matricularEstudiante(3, 4, insc3,grad2 );	
		repoEstCarrera.matricularEstudiante(4, 6, insc2,grad1 );
		repoEstCarrera.matricularEstudiante(4, 1, insc5, grad2);
		repoEstCarrera.matricularEstudiante(5, 1, insc4, null);
		repoEstCarrera.matricularEstudiante(5, 5, insc3, grad3);
		repoEstCarrera.matricularEstudiante(6, 1, insc3, grad4);
		repoEstCarrera.matricularEstudiante(7, 1, insc4, grad2);
		repoEstCarrera.matricularEstudiante(7, 3, insc4, grad3);
		repoEstCarrera.matricularEstudiante(8, 2, insc4, null);
		repoEstCarrera.matricularEstudiante(9, 2, insc1, grad4);
		repoEstCarrera.matricularEstudiante(10, 2, insc2, null);		
		repoEstCarrera.matricularEstudiante(6, 2, insc3, grad2);
		repoEstCarrera.matricularEstudiante(2, 3, insc3,grad1);
		repoEstCarrera.matricularEstudiante(1, 3, insc5,grad4 );
		repoEstCarrera.matricularEstudiante(4, 3, insc3, grad2);
		repoEstCarrera.matricularEstudiante(10, 4, insc5, null);

// ----------------PRIMERO TENER DESCOMENTADO TODO LO DE ARRIBA Y COMENTADO TODO LO DE ABAJO DE ESTA LINEA Y EJECUTAR, DESPUES AL REVES--------------

		
		/* EstudianteCarreraRepositoryImpl repoEstCarrera = new EstudianteCarreraRepositoryImpl(em);
		CarreraRepositoryImpl repoCarrera = new CarreraRepositoryImpl(em);	
		EstudianteRepositoryImpl eri = new EstudianteRepositoryImpl(em);
		
		System.out.println("Recuperar todos los estudiantes por apellido");

		List<DtoEstudiante> dtoEstudiante = eri.listaPorApellido();
		for (DtoEstudiante d : dtoEstudiante) {
			System.out.println("NOMBRE: "+d.getNombre() + " APELLIDO: " + d.getApellido() + " EDAD: " + d.getEdad() + " LIBRETA UNIVERSITARIA: " + d.getLibreta()	+ " CIUDAD: " + d.getCiudad());
			System.out.println("-----------------------------------");
		}
		

		System.out.println("Recuperar un estudiante, en base a su numero de libreta universitaria ");
		DtoEstudiante estudiantePorLibreta = eri.estudiantePorLibreta(778811);
		System.out.println("NOMBRE: "+estudiantePorLibreta.getNombre() + " APELLIDO: " + estudiantePorLibreta.getApellido() + " EDAD: "	+ estudiantePorLibreta.getEdad() + " LIBRETA UNIVERSITARIA: " + estudiantePorLibreta.getLibreta() + " CIUDAD: "	+ estudiantePorLibreta.getCiudad());
		System.out.println("-----------------------------------");

		
		System.out.println("Recuperar todos los estudiantes, en base a su genero.");
		List<DtoEstudiante> estudiantesPorGenero = eri.listaPorGenero("fem");
		for (DtoEstudiante d : estudiantesPorGenero) {
			System.out.println("NOMBRE: "+d.getNombre() + " APELLIDO: " + d.getApellido() + " EDAD: " + d.getEdad() + " GENERO: " + d.getGenero()+ " CIUDAD: " + d.getCiudad());
		}
		System.out.println("-----------------------------------");
		

		System.out.println("Recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.");
		List<DtoCarrera> carrerasConInscriptos = repoEstCarrera.carrerasConInscriptos();
		for (DtoCarrera d : carrerasConInscriptos) {
			System.out.println("NOMBRE DE LA CARRERA: " + d.getNombre() + " DURACION: " + d.getDuracion() + " ANIOS");
		}
		System.out.println("-----------------------------------");

		System.out.println("Recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia");
		List<DtoEstudianteCarrera> dto = repoEstCarrera.estudiantesPorCarreraFiltroCiudad(1, "tandil");
		for (DtoEstudianteCarrera d : dto) {
			System.out.println("NOMBRE: "+d.getNombre() + " APELLIDO: " + d.getApellido() + " CIUDAD: " + d.getCiudad() + " CARRERA: " + d.getCarrera());
		}
		System.out.println("-----------------------------------");
		

		System.out.println("Generar un reporte de las carreras, que para cada carrera incluya informacion de los inscriptos y egresados por anio. Se deben ordenar las carreras alfabeticamente, y presentar los anios de manera cronologica.");
		for (Object[] resultado : repoEstCarrera.getInforme()) {
			String nombreCarrera = (String) resultado[0];
			int anio = ((Number) resultado[1]).intValue();
			long inscriptos = ((Number) resultado[2]).longValue();
			long egresados = ((Number) resultado[3]).longValue();
			System.out.println("CARRERA: " + nombreCarrera + ", ANIO: " + anio + ", INSCRIPTOS: " + inscriptos+ ", EGRESADOS: " + egresados);

		}
		em.close();
 */
	}
}