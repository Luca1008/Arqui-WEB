package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class CarreraEstudiante {
    @Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "estudiante_id")
	private int estudianteId;
	@Column
	private int dni;
	@Column
	private String nombre;
	@Column
	private String apellido;
	@Column
	private int edad;
	@Column
	private String genero;
	
	@Column (name="ciudad")
	private String ciudadResidencia;
	
	@Column
	private int LU;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "estudiante")
	private Set<CarreraEstudiante> carreras;
	
	public void Estudiante(int dni, String nombre, String apellido, int edad, String genero, String ciudad, int Lu) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.genero = genero;
		this.dni = dni;
		this.ciudadResidencia = ciudad;
		this.LU = Lu;
		this.carreras = new HashSet<CarreraEstudiante>();
	}

	public void Estudiante() {
	
	}

	public String getNombres() {
		return nombre;
	}

	public void setNombres(String nombres) {
		this.nombre = nombres;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getDni() {
		return dni;
	}

	

	public int getId_estudiante() {
		return estudianteId;
	}

	public String getCiudadResidencia() {
		return ciudadResidencia;
	}

	public void setCiudadResidencia(String ciudadResidencia) {
		this.ciudadResidencia = ciudadResidencia;
	}

	public int getNumeroLibreta() {
		return LU;
	}

	public void setNumeroLibreta(int numeroLibreta) {
		this.LU = numeroLibreta;
	}
	
	public Set<CarreraEstudiante> getCarreras() {
		return carreras;
	}

	public void setJugadores(Set<CarreraEstudiante> carreras) {
		this.carreras = carreras;
	}

	@Override
	public String toString() {
		return "Estudiante [id_estudiante=" + estudianteId + ", dni=" + dni + ", nombre=" + nombre + ", apellido="
				+ apellido + ", edad=" + edad + ", genero=" + genero + ", ciudadResidencia=" + ciudadResidencia
				+ ", LU=" + LU + ", carreras=" + carreras + "]";
	}
}
