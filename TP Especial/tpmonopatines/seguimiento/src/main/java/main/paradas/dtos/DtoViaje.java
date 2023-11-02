package main.paradas.dtos;

import java.sql.Date;
import java.sql.Time;

import lombok.Data;
import main.paradas.model.monopatin;

@Data
public class DtoViaje {
    private Long nro_viaje;
    private Date fecha_inicio;
    private Time hora_inicio;
    private Date fecha_fin;
    private Time hora_fin;
    private int km_recorridos;
    private Time pausa;
    private int precio;
    private monopatin monopatin;

    public DtoViaje(Long nro_viaje, Date fecha_inicio, Time hora_inicio, Date fecha_fin, Time hora_fin,
            int km_recorridos, Time pausa, int precio, main.paradas.model.monopatin monopatin) {
        this.nro_viaje = nro_viaje;
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
