package com.example.demo.dtos;

import java.util.List;

import lombok.Getter;
@Getter
public class DtoCarreraMod {
	private String nombre;
	private List<DtoEstudiante> porInscripcion;
    private List<DtoEstudiante> porEgreso;
    
    public DtoCarreraMod(String nombre, List<DtoEstudiante> porInscripcion, List<DtoEstudiante> porEgreso) {
        this.nombre = nombre;
        this.porInscripcion = porInscripcion;
        this.porEgreso = porEgreso;
    }

}
