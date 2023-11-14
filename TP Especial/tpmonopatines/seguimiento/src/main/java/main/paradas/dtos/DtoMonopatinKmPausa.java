package main.paradas.dtos;

import java.sql.Time;

import lombok.Data;

@Data
public class DtoMonopatinKmPausa {
    private Long id;
    private Double km_recorridos;
    private Time pausa;


    public DtoMonopatinKmPausa(Object id, Object km_recorridos, Object pausa) {
        this.id = (Long) id;
        this.km_recorridos = (Double) km_recorridos;
        this.pausa = (Time) pausa;
    }
}