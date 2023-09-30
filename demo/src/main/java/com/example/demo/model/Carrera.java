package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<CarreraEstudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(Set<CarreraEstudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public int getId_carrera() {
		return carreraId;
	}

	@Override
	public String toString() {
		return "Carrera [id_carrera=" + carreraId + ", nombre=" + nombre + "]";
	}

}

