package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import jakarta.persistence.Table;


@Entity
@Table(name="TABLA_CARRERAS")
public class Carrera implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id_carrera;
	@Column
	private String carrera;
	@Column
	private String duracion;
	
	@ManyToMany(mappedBy = "carreras")
    private List<Estudiante> estudiantes;

	
	public Carrera() {
		super();
	}
	
	public Carrera(String nombre, String duracion) {
		this.carrera=nombre;
		this.duracion=duracion;
	}

	public String getId_carrera() {
		return id_carrera;
	}

	public void setId_carrera(String id_carrera) {
		this.id_carrera = id_carrera;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String nombre) {
		this.carrera = nombre;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	@Override
	public String toString() {
		return "Carrera [id_carrera=" + id_carrera + ", nombre=" + carrera + ", duracion=" + duracion + "]";
	}
	
}
