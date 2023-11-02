package main.paradas.dtos;

import java.sql.Time;

import lombok.Data;
import main.paradas.model.parada;

@Data
public class DtoMonopatin {
    private Long id_monopatin;
    private Time tiempo_uso;
    private Double km_recorridos;
    private Boolean monopatin_mantenimiento;
    private int x;
    private int y;
    private parada parada;

    public DtoMonopatin(Long id_monopatin, Time tiempo_uso, Double km_recorridos, Boolean monopatin_mantenimiento,
            int x, int y, parada parada) {
        this.id_monopatin = id_monopatin;
        this.tiempo_uso = tiempo_uso;
        this.km_recorridos = km_recorridos;
        this.monopatin_mantenimiento = monopatin_mantenimiento;
        this.x = x;
        this.y = y;
        this.parada = parada;
    }
}