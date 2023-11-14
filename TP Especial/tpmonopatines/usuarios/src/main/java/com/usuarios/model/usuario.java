package com.usuarios.model;

import java.util.List;
import java.util.Set;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
public class usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private int celular;
    private String email;

    @ManyToMany()
    @JoinTable(
            name = "usuario_cuenta",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "cuenta_id")
    )
    private Set<cuenta> cuentas;

    @ManyToMany
    @JoinTable(
            name = "usuario_autoridad",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "autoridad_id")
    )
    private Set<autoridad> autoridades;

    public usuario(String nombre, String apellido, int celular, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.email = email;
    }
}