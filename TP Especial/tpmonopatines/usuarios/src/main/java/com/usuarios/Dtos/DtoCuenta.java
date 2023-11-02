package com.usuarios.Dtos;

import java.sql.Date;
import java.util.List;
import com.usuarios.model.usuario;

import lombok.Data;

@Data
public class DtoCuenta {

    private Long nro_cuenta;
    private int dinero;
    private Date fechaAlta;
    private Boolean activada;
    private List<usuario> usuarios;

    public DtoCuenta() {
    }
    public DtoCuenta(Long cuenta, int dinero, Date fecha, Boolean activada, List<usuario> usuarios) {
        this.nro_cuenta = cuenta;
        this.dinero = dinero;
        this.fechaAlta = fecha;
        this.activada = activada;
        this.usuarios = usuarios;
    }
}