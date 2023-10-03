package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Carrera {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_carrera")
	private int id_carrera;
	@Column
	private String carrera;

	@Column
	private int duracion;

	public Carrera() {

	}

	public Carrera(int id_carrera, String carrera, int duracion) {
		this.id_carrera = id_carrera;
		this.carrera = carrera;
		this.duracion = duracion;
	}

	@Override
	public String toString() {
		return "Carrera [id_carrera=" + id_carrera + ", nombre=" + carrera + "]";
	}

}
