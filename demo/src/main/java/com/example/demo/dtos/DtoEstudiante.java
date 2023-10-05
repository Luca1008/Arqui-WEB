package com.example.demo.dtos;

import java.util.List;
import java.util.ArrayList;


import com.example.demo.model.EstudianteCarrera;

import lombok.Getter;
@Getter
public class DtoEstudiante {
	private Long dni;
	private String nombre;
	private String apellido;
	private int edad;
	private String ciudad;
	private String genero;
	private int libreta;

	public DtoEstudiante(Long dni, String nombre, String apellido, int edad, String ciudad, String genero, int libreta) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.ciudad = ciudad;
		this.genero = genero;
		this.libreta = libreta;
	}
}
