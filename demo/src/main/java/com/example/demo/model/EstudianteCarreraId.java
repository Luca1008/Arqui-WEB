package com.example.demo.model;

import java.io.Serializable;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Column;

@Embeddable
public class EstudianteCarreraId implements Serializable {
    private static final long serialVersionUID = 1L;
	
	@Column (name = "estudiante_id")
	private Long estudianteId;
	
	@Column (name = "carrera_id")
	private Long carreraId;
    
   public EstudianteCarreraId(Long a, Long b) {
        this.estudianteId = a;
		this.carreraId = b;
    }

    public EstudianteCarreraId() {
   }
   public Long getEstudiante_id() {
    return estudianteId;
}

    public Long getCarrera_id() {
        return carreraId;
    }
}
