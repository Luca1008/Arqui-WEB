package main.mantenimiento.model;

import java.sql.Time;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class mantenimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nro_atencion;
    private Time tiempo_uso;
    private Double km_recorridos;

    public mantenimiento() {
    }

    public mantenimiento(Time tiempo_uso, Double km_recorridos) {
        this.tiempo_uso = tiempo_uso;
        this.km_recorridos = km_recorridos;
    }
}
