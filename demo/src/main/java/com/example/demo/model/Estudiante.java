package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_estudiante;

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


    public Estudiante(int dni, String nombre, String apellido, int edad, String genero, String ciudad, int Lu) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.dni = dni;
        this.ciudad = ciudad;
        this.LU = Lu;
    }
    public Estudiante() {

    }

}
