package Entidades;

import java.io.Serializable;
import javax.persistence.*;



@Entity
@Table(name="INSCRIPCIONES")
public class EstudianteCarrera implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private Long id_estudiante;
	private Long id_carrera;
    private int antiguedad;
    private int graduado;
	private int inscripcion;
	
    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "carrera_id")
    private Carrera carrera;

	public EstudianteCarrera() {
	}

	public EstudianteCarrera(Long id, int antiguedad, int graduado, Estudiante estudiante, Carrera carrera) {
		this.id = id;
		this.antiguedad = antiguedad;
		this.graduado = graduado;
		this.estudiante = estudiante;
		this.carrera = carrera;
	}

	


	public EstudianteCarrera(Long id, Long id_estudiante, Long id_carrera, int antiguedad, int graduado,
			int inscripcion) {
		this.id = id;
		this.id_estudiante = id_estudiante;
		this.id_carrera = id_carrera;
		this.antiguedad = antiguedad;
		this.graduado = graduado;
		this.inscripcion = inscripcion;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}

	public int isGraduado() {
		return graduado;
	}

	public void setGraduado(int graduado) {
		this.graduado = graduado;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	@Override
	public String toString() {
		return "EstudianteCarrera [antiguedad=" + antiguedad + ", graduado=" + graduado + ", estudiante=" + estudiante
				+ ", carrera=" + carrera + "]";
	}
	

	
	
    
    
    
} 
