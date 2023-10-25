package com.usuarios.model;

import java.util.Set;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int dinero;
    private Date fechaAlta;

    // Relación muchos a muchos con Usuarios
    @ManyToMany
    private List<usuario> usuarios;

    public cuenta() {
    }

    public cuenta(int dinero, Date fechaAlta, List<usuario> usuarios) {
        this.dinero = dinero;
        this.fechaAlta = fechaAlta;
        this.usuarios = usuarios;
    }
}
