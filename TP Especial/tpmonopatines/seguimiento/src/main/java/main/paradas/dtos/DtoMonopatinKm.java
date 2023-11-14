package main.paradas.dtos;

import lombok.Data;

@Data
public class DtoMonopatinKm {
    private Long id;
    private Double km_recorridos;


    public DtoMonopatinKm(Object id, Object km_recorridos) {
        this.id = (Long) id;
        this.km_recorridos = (Double) km_recorridos;
    }
}
