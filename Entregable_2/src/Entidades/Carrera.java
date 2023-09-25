package Entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="TABLA_CARRERAS")
public class Carrera implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
	private int duracion;

    @OneToMany(mappedBy = "carrera", cascade = CascadeType.ALL)
    private List<EstudianteCarrera> estudianteCarreras = new ArrayList<>();

	public Carrera() {
	}

	public Carrera(String nombre, int duracion) {
		this.nombre = nombre;
		this.duracion = duracion;
		this.estudianteCarreras = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Carrera [nombre=" + nombre + "]";
	}

	

	
	
}
