package main.paradas.dtos;

import java.sql.Time;

import lombok.Getter;

@Getter
public class DtoMonopatinKmPausa {
    private Long id_monopatin;
    private Double km_recorridos;
    private Time pausa;


    public DtoMonopatinKmPausa(Object id_monopatin, Object km_recorridos, Object pausa) {
        this.id_monopatin = (Long) id_monopatin;
        this.km_recorridos = (Double) km_recorridos;
        this.pausa = (Time) pausa;
    }
}