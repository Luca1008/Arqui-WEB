package Entidades;

import java.io.Serializable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import jakarta.persistence.Table;

import javax.persistence.Entity;

@Entity
@Table(name="TABLA_ESTUDIANTES")
public class Estudiante implements Serializable {
	@Id
	private String DNI;
	@Column
	private String nombre;
	@Column
	private String apellido;
	@Column
	private String edad;
	@Column
	private String genero;
	@Column
	private String ciudad;
	@Column
	private String libreta_universitaria;
	
	@ManyToMany
    @JoinTable(name = "estudiante_carrera",
               joinColumns = @JoinColumn(name = "estudiante_id"),
               inverseJoinColumns = @JoinColumn(name = "carrera_id"))
	 @Column(name = "fecha_inscripcion") 
    private List<Carrera> carreras;

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getLibreta_universitaria() {
		return libreta_universitaria;
	}

	public void setLibreta_universitaria(String libreta_universitaria) {
		this.libreta_universitaria = libreta_universitaria;
	}

	public List<Carrera> getCarreras() {
		return carreras;
	}

	public void setCarreras(List<Carrera> carreras) {
		this.carreras = carreras;
	}
	

}
