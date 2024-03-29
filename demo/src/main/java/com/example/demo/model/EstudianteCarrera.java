package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "estudiante_carrera")
public class EstudianteCarrera {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_estudiante")
	private Estudiante estudiante;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_carrera")
	private Carrera carrera;

	@Column
	private int inscripcion;

	@Column
	private int graduacion;

	@Column
	private int antiguedad;

	public EstudianteCarrera() {

	}

	public EstudianteCarrera(Estudiante estudiante, Carrera carrera, int inscripcion, int graduacion, int antiguedad) {
		this.estudiante = estudiante;
		this.carrera = carrera;
		this.inscripcion = inscripcion;
		this.graduacion = graduacion;
		this.antiguedad = antiguedad;
	}
}
