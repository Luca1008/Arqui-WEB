package com.example.demo.model;


import java.util.List;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "carrera")
public class Carrera {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_carrera;

	@OneToMany(mappedBy = "carrera")
    private List<EstudianteCarrera> estudianteCarrera;
	
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
