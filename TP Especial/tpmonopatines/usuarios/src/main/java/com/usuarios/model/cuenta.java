package com.usuarios.model;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nro_cuenta;

    private int dinero;
    private Date fechaAlta;
    private Boolean activada;

    // Relación muchos a muchos con Usuarios
    @JsonIgnore
    @ManyToMany (mappedBy = "cuentas")
    private List<usuario> usuarios;

    public cuenta() {
    }

    public cuenta(int dinero, Date fechaAlta) {
        this.dinero = dinero;
        this.fechaAlta = fechaAlta;
    }
}
