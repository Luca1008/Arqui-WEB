package com.example.demo.dtos;

import lombok.Getter;

@Getter
public class DtoEstudianteMod {
	private Long dni;
	private String nombre;
	private String apellido;
	private int edad;
	private String ciudad;
	private String genero;
	private int libreta;
    private int inscripcion;
    private int graduacion;

    public DtoEstudianteMod(Long dni, String nombre, String apellido, int edad, String ciudad, String genero,
            int libreta, int inscripcion, int graduacion) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.ciudad = ciudad;
        this.genero = genero;
        this.libreta = libreta;
        this.inscripcion = inscripcion;
        this.graduacion = graduacion;
    }
}
