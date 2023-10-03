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
	private Long id;

	@ManyToOne
	@JoinColumn(name = "estudiante_id")
	private Estudiante estudiante;

	@ManyToOne
	@JoinColumn(name = "id_carrera")
	private Carrera carrera;

	@Column
	private Timestamp inscripcion;

	@Column
	private Timestamp graduacion;

	@Column
	private int antiguedad;

	public CarreraEstudiante() {

	}

	public CarreraEstudiante(Estudiante estudiante, Carrera carrera, Timestamp inscripcion, Timestamp graduacion, int antiguedad) {
		this.estudiante = estudiante;
		this.carrera = carrera;
		this.inscripcion = inscripcion;
		this.graduacion = graduacion;
		this.antiguedad = antiguedad;
	}
}
