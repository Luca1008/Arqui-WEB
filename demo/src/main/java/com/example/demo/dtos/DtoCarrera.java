package com.example.demo.dtos;

import lombok.Getter;

@Getter
public class DtoCarrera {
	private String nombre;
	private int Cant;

	public DtoCarrera(Object resultado, Object resultado2) {
		this.nombre = (String) resultado;
		this.Cant = (int) resultado2;
	}
}
