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
    private String numeroIdentificatorio;
    private String fechaAlta;

    // Relación muchos a muchos con Usuarios
    @ManyToMany
    private Set<usuario> usuarios;

    public cuenta() {
    }

    public cuenta(String numeroIdentificatorio, String fechaAlta) {
        this.numeroIdentificatorio = numeroIdentificatorio;
        this.fechaAlta = fechaAlta;
    }

    
}
