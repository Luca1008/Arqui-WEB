package main.mantenimiento.model;

import java.sql.Date;
import java.util.Set;

import ch.qos.logback.core.util.Duration;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class mantenimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nro_atencion;
    private Duration tiempo_uso;
    private Double km_recorridos;

    public mantenimiento() {
    }

    public mantenimiento(Duration tiempo_uso, Double km_recorridos) {
        this.tiempo_uso = tiempo_uso;
        this.km_recorridos = km_recorridos;
    }
}
