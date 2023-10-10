package com.example.demo.dtos;

import lombok.Getter;

@Getter
public class DtoCarrera {
	private String nombre;
	private Long Cant;

	public DtoCarrera(Object resultado, Object resultado2) {
		this.nombre = (String) resultado;
		this.Cant = (Long) resultado2;
	}
}

