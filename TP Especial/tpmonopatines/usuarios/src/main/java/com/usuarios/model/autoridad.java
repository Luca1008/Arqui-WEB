package com.usuarios.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
public class autoridad implements Serializable {

    @Id    
    @Column(length = 50, nullable = false)
    private String nombre;
}
