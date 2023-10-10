package com.example.demo.dtos;

import java.util.List;

import lombok.Getter;
@Getter
public class DtoCarreraMod {
	private String nombre;
	private List<DtoEstudianteMod> porInscripcion;
    private List<DtoEstudianteMod> porEgreso;
    
    public DtoCarreraMod(String nombre, List<DtoEstudianteMod> porInscripcion, List<DtoEstudianteMod> porEgreso) {
        this.nombre = nombre;
        this.porInscripcion = porInscripcion;
        this.porEgreso = porEgreso;
    }

}
