package com.example.demo.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "estudiante")
public class Estudiante {
    @Id
    private Long id_estudiante;

    @OneToMany(mappedBy = "estudiante")
    private List<EstudianteCarrera> estudianteCarreras;

    @Column
    private String nombre;
    
    @Column
    private String apellido;

    @Column
    private int edad;

    @Column(name = "genero")
    private String genero;

    @Column
    private String ciudad;

    @Column
    private int LU;

    public Estudiante(Long id_estudiante, String nombre, String apellido, int edad, String genero, String ciudad, int Lu) {
        this.id_estudiante = id_estudiante;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.ciudad = ciudad;
        this.LU = Lu;
    }

    public Estudiante() {

    }

}
