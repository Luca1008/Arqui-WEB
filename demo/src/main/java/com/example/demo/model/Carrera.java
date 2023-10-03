package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Data;



@Entity
@Data
public class Carrera {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "carrera_id")
	private int carreraId;
	@Column
	private String nombre;

	@Column
	private int duracion;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "carrera")
	private Set<CarreraEstudiante> estudiantes;

	public Carrera() {

	}

	public Carrera(String nombre, int duracion) {
		this.nombre = nombre;
		this.duracion = duracion;
		this.estudiantes = new HashSet<CarreraEstudiante>();
	}
	
	@Override
	public String toString() {
		return "Carrera [id_carrera=" + carreraId + ", nombre=" + nombre + "]";
	}

}
