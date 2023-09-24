package Entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="TABLA_ESTUDIANTES")
public class Estudiante implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombres;
    private String apellido;
    private int edad;
    private String genero;
    private String numDocumento;
    private String ciudadResidencia;
    private String numLibretaUniversitaria;
    private boolean graduado;
	
	@OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL)
    private List<EstudianteCarrera> estudianteCarreras = new ArrayList<>();

	public Estudiante() {
	}

	public Estudiante(String nombres, String apellido, int edad, String genero, String numDocumento,
			String ciudadResidencia, String numLibretaUniversitaria, boolean graduado) {
		this.nombres = nombres;
		this.apellido = apellido;
		this.edad = edad;
		this.genero = genero;
		this.numDocumento = numDocumento;
		this.ciudadResidencia = ciudadResidencia;
		this.numLibretaUniversitaria = numLibretaUniversitaria;
		this.graduado = graduado;
		estudianteCarreras = new ArrayList<>();
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
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

	public String getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}

	public String getCiudadResidencia() {
		return ciudadResidencia;
	}

	public void setCiudadResidencia(String ciudadResidencia) {
		this.ciudadResidencia = ciudadResidencia;
	}

	public String getNumLibretaUniversitaria() {
		return numLibretaUniversitaria;
	}

	public void setNumLibretaUniversitaria(String numLibretaUniversitaria) {
		this.numLibretaUniversitaria = numLibretaUniversitaria;
	}

	public boolean isGraduado() {
		return graduado;
	}

	public void setGraduado(boolean graduado) {
		this.graduado = graduado;
	}

	@Override
	public String toString() {
		return "Estudiante [nombres=" + nombres + ", apellido=" + apellido + ", edad=" + edad + ", genero=" + genero
				+ ", numDocumento=" + numDocumento + ", ciudadResidencia=" + ciudadResidencia
				+ ", numLibretaUniversitaria=" + numLibretaUniversitaria + ", graduado=" + graduado + "]";
	}

	
	

}
