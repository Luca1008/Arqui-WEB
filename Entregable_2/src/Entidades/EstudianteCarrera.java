package Entidades;

import java.io.Serializable;
import javax.persistence.*;



@Entity
@Table(name="INSCRIPCIONES")
public class EstudianteCarrera implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int antiguedad;
    private boolean graduado;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "carrera_id")
    private Carrera carrera;

	public EstudianteCarrera() {
	}

	public EstudianteCarrera(int antiguedad, boolean graduado, Estudiante estudiante, Carrera carrera) {
		this.antiguedad = antiguedad;
		this.graduado = graduado;
		this.estudiante = estudiante;
		this.carrera = carrera;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}

	public boolean isGraduado() {
		return graduado;
	}

	public void setGraduado(boolean graduado) {
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
