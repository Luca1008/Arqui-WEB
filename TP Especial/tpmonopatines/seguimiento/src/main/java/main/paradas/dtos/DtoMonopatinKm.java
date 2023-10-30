package main.paradas.dtos;

import lombok.Getter;

@Getter
public class DtoMonopatinKm {
    private Long id_monopatin;
    private Double km_recorridos;


    public DtoMonopatinKm(Object id_monopatin, Object km_recorridos) {
        this.id_monopatin = (Long) id_monopatin;
        this.km_recorridos = (Double) km_recorridos;
    }
}
