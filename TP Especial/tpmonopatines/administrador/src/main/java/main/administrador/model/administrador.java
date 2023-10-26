package main.administrador.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class administrador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_administrador;
    private int tarifa;
    private int tarifaPausa;

}
