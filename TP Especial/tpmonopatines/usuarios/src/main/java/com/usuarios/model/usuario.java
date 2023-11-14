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

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false)
    private int celular;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String contrasenia;

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

    public usuario(String nombre, String apellido, int celular, String email, String contrasenia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.email = email;
        this.contrasenia = contrasenia;
    }
}