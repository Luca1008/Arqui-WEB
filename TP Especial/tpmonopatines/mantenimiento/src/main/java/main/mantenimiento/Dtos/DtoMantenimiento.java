package main.mantenimiento.Dtos;

import java.sql.Time;

import lombok.Data;

@Data
public class DtoMantenimiento{

    private Long nro_atencion;
    private Time tiempo_uso;
    private Double km_recorridos;
    
    public DtoMantenimiento(Long nro_atencion, Time tiempo_uso, Double km_recorridos) {
        this.nro_atencion = nro_atencion;
        this.tiempo_uso = tiempo_uso;
        this.km_recorridos = km_recorridos;
    }

}