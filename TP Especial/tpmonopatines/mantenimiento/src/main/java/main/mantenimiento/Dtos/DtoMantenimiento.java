package main.mantenimiento.Dtos;

import java.sql.Time;

import lombok.Data;

@Data
public class DtoMantenimiento{

    private Long id;
    private Time tiempo_uso;
    private Double km_recorridos;
    
    public DtoMantenimiento(Long id, Time tiempo_uso, Double km_recorridos) {
        this.id = id;
        this.tiempo_uso = tiempo_uso;
        this.km_recorridos = km_recorridos;
    }

}