package main.paradas.model;
import jakarta.persistence.*;
import lombok.*;
import java.sql.Time;
import java.sql.Date;


@Data
@Entity
public class viaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nro_viaje;
    private Date fecha_inicio;
    private Time hora_inicio;
    private Date fecha_fin;
    private Time hora_fin;
    private int km_recorridos;
    private Time pausa;
    @ManyToOne
    private monopatin id_monopatin; 



    public viaje() {
    }
    public viaje(Date fecha_inicio, Time hora_inicio, Date fecha_fin,Time hora_fin, int km_recorridos, Time pausa, monopatin id_monopatin){
        this.fecha_inicio=fecha_inicio;
        this.fecha_fin=fecha_fin;
        this.hora_fin=hora_fin;
        this.hora_inicio=hora_inicio;
        this.km_recorridos=km_recorridos;
        this.pausa=pausa;
        this.id_monopatin=id_monopatin;
    }

}