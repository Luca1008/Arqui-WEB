package main.mantenimiento.Dtos;

import java.sql.Time;
import java.time.Instant;
import java.time.LocalTime;

import lombok.Data;

@Data
public class DtoMantenimiento{

    private String id;
    private Instant tiempo_uso;
    private Double km_recorridos;
    
    public DtoMantenimiento(String id, Instant tiempo_uso, Double km_recorridos) {
        this.id = id;
        this.tiempo_uso = tiempo_uso;
        this.km_recorridos = km_recorridos;
    }
}