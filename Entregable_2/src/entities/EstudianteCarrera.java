package entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;


@Entity
@Table(name ="estudiante_carrera")
public class EstudianteCarrera{
		
	@EmbeddedId 
	private CarreraEstudianteId idEstudianteCarrera;
	
	@ManyToOne(targetEntity = Estudiante.class)
	@MapsId("estudianteId")
	@JoinColumn(name = "estudiante_id")
	private Estudiante estudiante;

	@ManyToOne (targetEntity = 	Carrera.class)
	@MapsId("carreraId")
	@JoinColumn(name = "carrera_id")
	private Carrera carrera;
	@Column
	private Timestamp inscripcion;
	@Column
	private Timestamp egreso;
	@Column  
	private int antiguedad;
	@Column
	private Boolean graduado;

	public EstudianteCarrera() {
		
	}
	
	public EstudianteCarrera(Estudiante e, Carrera c, Timestamp anio_inscripcion, Timestamp anio_egreso, CarreraEstudianteId id) {
		this.idEstudianteCarrera = id;
		this.estudiante = e;
		this.carrera = c;
		this.inscripcion = anio_inscripcion;
		this.egreso = anio_egreso;
		this.antiguedad = this.getAntiguedad(anio_inscripcion);
		this.graduado = this.verificarGraduado(anio_egreso);
	}

	public boolean isGraduado() {
		return graduado;
	}
	
	public boolean verificarGraduado(Timestamp anio_egreso) {
		return !(anio_egreso == null);
	}

	public void setGraduado(boolean graduado) {
		this.graduado = graduado;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public Timestamp getAnio_inscripcion() {
		return this.inscripcion;
	}

	public Timestamp getAnio_egreso() {
		return this.egreso;
	}

	public void setAnio_inscripcion(Timestamp anio_inscripcion) {
		this.inscripcion = anio_inscripcion;
	}

	public void setAnio_egreso(Timestamp anio_egreso) {
		this.egreso = anio_egreso;
	}

	public Integer getAntiguedad(Timestamp anio_inscripcion) {
		Calendar fechaInscripcion = Calendar.getInstance();
		fechaInscripcion.setTimeInMillis(this.inscripcion.getTime());
		return Calendar.getInstance().get(Calendar.YEAR) - fechaInscripcion.get(Calendar.YEAR);
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}

	public CarreraEstudianteId getIdEstudianteCarrera() {
		return idEstudianteCarrera;
	}

	@Override
	public String toString() {
		return "EstudianteCarrera [idEstudianteCarrera=" + idEstudianteCarrera + ", fecha_inscripcion=" + inscripcion + ", fecha_egreso=" + egreso
				+ ", antiguedad=" + antiguedad + "]";
	}

	public void setIdEstudianteCarrera(CarreraEstudianteId idComp) {
		// TODO Auto-generated method stub
		
	}

	public void setFecha_inscripcion(Timestamp inscrip) {
		// TODO Auto-generated method stub
		
	}

	
}
