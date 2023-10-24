package com.usuarios.model;

import java.util.Set;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int celuler;
    private String email;
    @ManyToMany
    private Set<cuenta> cuentas;
    
    public usuario() {
    }
    public usuario(String nombre, int celuler, String email) {
        this.nombre = nombre;
        this.celuler = celuler;
        this.email = email;
    }
}
