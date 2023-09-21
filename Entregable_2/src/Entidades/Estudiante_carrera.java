package Entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import jakarta.persistence.Table;


@Entity
@Table(name="INSCRIPCIONES")
public class Estudiante_carrera implements Serializable {
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private String id;

	@Column
	private String inscripcion;
	@Column
	private String graduacion;
	@Column
	private String antiguedad;
	



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInscripcion() {
		return inscripcion;
	}

	public void setInscripcion(String inscripcion) {
		this.inscripcion = inscripcion;
	}

	public String getGraduacion() {
		return graduacion;
	}

	public void setGraduacion(String graduacion) {
		this.graduacion = graduacion;
	}

	public String getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(String antiguedad) {
		this.antiguedad = antiguedad;
	}

	
	@Override
	public String toString() {
		return "estudiante_carrera [id=" + id + ", id_estudiante=" 
				+ ", inscripcion=" + inscripcion + ", graduacion=" + graduacion + ", antiguedad=" + antiguedad+ "]";
	}
	
    
    
    
} 
