package main.mantenimiento.model;

import java.sql.Time;
import java.time.Instant;
import java.time.LocalTime;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection = "mantenimiento")
public class mantenimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(nullable = false)
    private Instant tiempo_uso;

    @Column(nullable = false)
    private Double km_recorridos = 0.0;

    public mantenimiento(Instant tiempo_uso, Double km_recorridos) {
        this.tiempo_uso = tiempo_uso;
        this.km_recorridos = km_recorridos;
    }
}