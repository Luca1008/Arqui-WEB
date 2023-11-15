package com.usuarios.Dtos;

import java.sql.Date;
import java.util.Set;

import com.usuarios.model.usuario;

import lombok.Data;

@Data
public class DtoCuenta {

    private Long id;
    private int dinero;
    private Date fechaAlta;
    private Boolean activada;
    private Set<usuario> usuarios;

    public DtoCuenta() {
    }
    public DtoCuenta(Long cuenta, int dinero, Date fecha, Boolean activada, Set<usuario> usuarios) {
        this.id = cuenta;
        this.dinero = dinero;
        this.fechaAlta = fecha;
        this.activada = activada;
        this.usuarios = usuarios;
    }
}