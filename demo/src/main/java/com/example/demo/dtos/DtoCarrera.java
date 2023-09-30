package com.example.demo.dtos;

import java.util.List;
import java.util.ArrayList;

import com.example.demo.model.Carrera;

public class DtoCarrera {
	private String nombre;
	private int duracion;

	public DtoCarrera(String nombre, int duracion) {
		this.nombre = nombre;
		this.duracion = duracion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDuracion() {
		return duracion;
	}

	@Override
	public String toString() {
		return "DtoCarrera [nombre=" + nombre + ", duracion=" + duracion + "]";
	}

}
