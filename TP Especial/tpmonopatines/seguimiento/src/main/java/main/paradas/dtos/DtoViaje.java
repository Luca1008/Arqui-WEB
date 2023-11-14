package main.paradas.dtos;

import java.sql.Date;
import java.sql.Time;

import lombok.Data;
import main.paradas.model.monopatin;

@Data
public class DtoViaje {
    private Long id;
    private Date fecha_inicio;
    private Time hora_inicio;
    private Date fecha_fin;
    private Time hora_fin;
    private Double km_recorridos;
    private Time pausa;
    private int precio;
    private monopatin monopatin;

    public DtoViaje(Long id, Date fecha_inicio, Time hora_inicio, Date fecha_fin, Time hora_fin,
            Double km_recorridos, Time pausa, int precio, main.paradas.model.monopatin monopatin) {
        this.id = id;
        this.fecha_inicio = fecha_inicio;
        this.hora_inicio = hora_inicio;
        this.fecha_fin = fecha_fin;
        this.hora_fin = hora_fin;
        this.km_recorridos = km_recorridos;
        this.pausa = pausa;
        this.precio = precio;
        this.monopatin = monopatin;
    }
}
