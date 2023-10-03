package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estudiante_id")
    private Long estudianteId;
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

    @Column(name = "ciudad")
    private String ciudad;

    @Column
    private int LU;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estudiante")
    private Set<CarreraEstudiante> carreras;

    public Estudiante(int dni, String nombre, String apellido, int edad, String genero, String ciudad, int Lu) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.dni = dni;
        this.ciudad = ciudad;
        this.LU = Lu;
        this.carreras = new HashSet<CarreraEstudiante>();
    }
    public Estudiante() {

    }

    
    @Override
    public String toString() {
        return "Estudiante [id_estudiante=" + estudianteId + ", dni=" + dni + ", nombre=" + nombre + ", apellido="
                + apellido + ", edad=" + edad + ", genero=" + genero + ", ciudad=" + ciudad
                + ", LU=" + LU + ", carreras=" + carreras + "]";
    }

}
