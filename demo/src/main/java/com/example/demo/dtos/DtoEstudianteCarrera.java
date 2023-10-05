package com.example.demo.dtos;

import lombok.Getter;

@Getter
public class DtoEstudianteCarrera {

	private String nombre;
	private String apellido;
	private String ciudad;
	private String carrera;

	public DtoEstudianteCarrera(String nombre, String apellido, String ciudad, String carrera) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.ciudad = ciudad;
		this.carrera = carrera;
	}
}
