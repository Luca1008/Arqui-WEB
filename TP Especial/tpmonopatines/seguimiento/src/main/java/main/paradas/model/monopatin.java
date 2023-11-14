package main.paradas.model;

import java.sql.Time;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@Entity
public class monopatin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Time tiempo_uso;

    @Column(nullable = false)
    private Double km_recorridos;

    @Column(nullable = false)
    private Boolean monopatin_mantenimiento = false;

    @Column(nullable = false)
    private int x;

    @Column(nullable = false)
    private int y;

    @JoinColumn(name = "id_parada", referencedColumnName = "id")
    @ManyToOne
    private parada parada;

    public monopatin(Time tiempo_uso, Double km_recorridos, Boolean monopatin_mantenimiento, int x,
            int y) {
        this.tiempo_uso = tiempo_uso;
        this.km_recorridos = km_recorridos;
        this.monopatin_mantenimiento = monopatin_mantenimiento;
        this.x = x;
        this.y = y;
    }
}