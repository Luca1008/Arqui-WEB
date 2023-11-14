package com.usuarios.model;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int dinero;

    @Column(nullable = false)
    private Date fechaAlta;

    @Column(nullable = false)
    private Boolean activada = true;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "cuentas")
    private Set<usuario> usuarios;

    public cuenta(int dinero, Date fechaAlta) {
        this.dinero = dinero;
        this.fechaAlta = fechaAlta;
    }
}
