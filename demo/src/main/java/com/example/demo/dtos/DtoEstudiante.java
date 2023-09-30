package com.example.demo.dtos;

import java.util.List;
import java.util.ArrayList;

import com.example.demo.model.CarreraEstudiante;

public class DtoEstudiante {
	private String apellido;
	private String nombre;
	private int edad;
	private String ciudad;
	private String genero;
	private int libreta;
	private List<CarreraEstudiante> carreras;

	public DtoEstudiante(String apellido, String nombre, int edad, String ciudad, String genero, int libreta) {
		super();
		this.apellido = apellido;
		this.nombre = nombre;
		this.edad = edad;
		this.ciudad = ciudad;
		this.genero = genero;
		this.libreta = libreta;
		this.carreras = new ArrayList<CarreraEstudiante>();
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<CarreraEstudiante> getCarreras() {
		return carreras;
	}

	public void setCarreras(List<CarreraEstudiante> carreras) {
		this.carreras = carreras;
	}

	@Override
	public String toString() {
		return "DtoEstudiante [apellido=" + apellido + ", nombre=" + nombre + ", carreras=" + carreras + "]";
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getGenero() {
		return genero;
	}

	public int getLibreta() {
		return libreta;
	}

	public void setLibreta(int libreta) {
		this.libreta = libreta;
	}

	public void setParameter(int i, int numeroLibreta) {

	}

}
