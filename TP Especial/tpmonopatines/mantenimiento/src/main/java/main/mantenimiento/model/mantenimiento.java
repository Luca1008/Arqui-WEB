package main.mantenimiento.model;

import java.sql.Time;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class mantenimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Time tiempo_uso;

    @Column(nullable = false)
    private Double km_recorridos = 0.0;

    public mantenimiento(Time tiempo_uso, Double km_recorridos) {
        this.tiempo_uso = tiempo_uso;
        this.km_recorridos = km_recorridos;
    }
}