package com.usuarios.Dtos;

import lombok.Data;

@Data
public class DtoUsuario {
    private Long id;
    private String nombre;
    private String apellido;
    private int celular;
    private String email;
    
    public DtoUsuario() {
    }

    public DtoUsuario(Long id, String nombre, String apellido, int celular, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.email = email;
    }
}