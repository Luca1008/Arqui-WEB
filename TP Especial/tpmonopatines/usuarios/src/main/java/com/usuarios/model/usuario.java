package com.usuarios.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private int celular;
    private String email;

    @JoinTable(
        name = "cuenta",
        joinColumns = @JoinColumn(name = "id_usuario"), 
        inverseJoinColumns = @JoinColumn(name = "nro_cuenta")
    )
    @JsonIgnore
    @ManyToMany
    private List<cuenta> cuentas;
    
    public usuario() {
    }

    public usuario(String nombre, String apellido, int celular, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.email = email;
    }
}