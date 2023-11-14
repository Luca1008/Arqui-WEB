package main.paradas.model;

import jakarta.persistence.*;
import lombok.*;
import java.sql.Time;
import java.sql.Date;

@Data
@NoArgsConstructor
@Entity
public class viaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date fecha_inicio;

    @Column(nullable = false)
    private Time hora_inicio;

    @Column(nullable = false)
    private Date fecha_fin;

    @Column(nullable = false)
    private Time hora_fin;

    @Column(nullable = false)
    private Double km_recorridos;

    @Column(nullable = false)
    private Time pausa;

    @Column(nullable = false)
    private int precio;

    @JoinColumn(name = "id_monopatin", referencedColumnName = "id")
    @ManyToOne
    private monopatin monopatin;

    public viaje(Date fecha_inicio, Time hora_inicio, Date fecha_fin, Time hora_fin, Double km_recorridos, Time pausa,
            int precio, monopatin monopatin) {
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.hora_fin = hora_fin;
        this.hora_inicio = hora_inicio;
        this.km_recorridos = km_recorridos;
        this.pausa = pausa;
        this.precio = precio;
        this.monopatin = monopatin;

    }

}