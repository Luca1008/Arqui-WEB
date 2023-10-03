package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Data
@Table(name = "estudiante_carrera")
public class CarreraEstudiante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@ManyToOne(targetEntity = Estudiante.class)
	@MapsId("id_estudiante")
	@JoinColumn(name = "id_estudiante")
	private int estudiante;

	@ManyToOne(targetEntity = Carrera.class)
	@MapsId("id_carrera")
	@JoinColumn(name = "id_carrera")
	private int carrera;
	@Column
	private Timestamp inscripcion;
	@Column
	private Timestamp graduacion;
	@Column
	private int antiguedad;

	public CarreraEstudiante() {

	}

	public CarreraEstudiante(int estudiante, int carrera, Timestamp inscripcion, Timestamp graduacion, int antiguedad) {
		this.estudiante = estudiante;
		this.carrera = carrera;
		this.inscripcion = inscripcion;
		this.graduacion = graduacion;
		this.antiguedad = antiguedad;
	}

	@Override
	public String toString() {
		return "EstudianteCarrera [idEstudianteCarrera=" + ", fecha_inscripcion=" + inscripcion
				+ ", fecha_egreso="
				+ ", antiguedad=" + antiguedad + "]";
	}

}
