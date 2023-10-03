package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;



@Entity
@Data
@Table(name = "estudiante_carrera")
public class CarreraEstudiante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@ManyToOne(targetEntity = Estudiante.class)
	@MapsId("estudianteId")
	@JoinColumn(name = "estudiante_id")
	private int estudiante;

	@ManyToOne(targetEntity = Carrera.class)
	@MapsId("carreraId")
	@JoinColumn(name = "carrera_id")
	private int carrera;
	@Column
	private Timestamp inscripcion;
	@Column
	private Timestamp egreso;
	@Column
	private int antiguedad;
	@Column
	private Boolean graduado;

	public CarreraEstudiante() {

	}

	public CarreraEstudiante(int e, int c, Timestamp anio_inscripcion, Timestamp anio_egreso) {
		this.estudiante = e;
		this.carrera = c;
		this.inscripcion = anio_inscripcion;
		this.egreso = anio_egreso;
		this.antiguedad = this.getAntiguedad(anio_inscripcion);
		this.graduado = this.verificarGraduado(anio_egreso);
	}

	public boolean isGraduado() {
		return graduado;
	}

	public boolean verificarGraduado(Timestamp anio_egreso) {
		return !(anio_egreso == null);
	}

	

	public Integer getAntiguedad(Timestamp anio_inscripcion) {
		Calendar fechaInscripcion = Calendar.getInstance();
		fechaInscripcion.setTimeInMillis(this.inscripcion.getTime());
		return Calendar.getInstance().get(Calendar.YEAR) - fechaInscripcion.get(Calendar.YEAR);
	}
	@Override
	public String toString() {
		return "EstudianteCarrera [idEstudianteCarrera=" + ", fecha_inscripcion=" + inscripcion
				+ ", fecha_egreso=" + egreso
				+ ", antiguedad=" + antiguedad + "]";
	}

}
