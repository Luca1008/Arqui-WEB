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
	private Long id_carrera;

	//Relacion con model.CarreraEstudiante
	@OneToMany(mappedBy = "carrera", targetEntity = CarreraEstudiante.class)
    private Set<CarreraEstudiante> carreraEstudiante = new HashSet<>();
	@Column
	private String carrera;

	@Column
	private int duracion;

	public Carrera() {

	}

	public Carrera(Long id_carrera, String carrera, int duracion) {
		this.id_carrera = id_carrera;
		this.carrera = carrera;
		this.duracion = duracion;
	}

	@Override
	public String toString() {
		return "Carrera [id_carrera=" + id_carrera + ", nombre=" + carrera + "]";
	}

}
