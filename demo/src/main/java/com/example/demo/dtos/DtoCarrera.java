package com.example.demo.dtos;

import lombok.Getter;

@Getter
public class DtoCarrera {
	private String nombre;
	private int duracion;

	public DtoCarrera(String nombre, int duracion) {
		this.nombre = nombre;
		this.duracion = duracion;
	}
}
