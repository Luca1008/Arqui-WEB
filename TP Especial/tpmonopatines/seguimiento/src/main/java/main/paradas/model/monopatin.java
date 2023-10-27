package main.paradas.model;

import java.sql.Time;
import java.util.List;

import jakarta.persistence.*;
import lombok.*; 



@Data
@Entity
public class monopatin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_monopatin;
    private Time tiempo_uso;
    private Double km_recorridos;
    private Boolean monopatin_mantenimiento;
    //private double latitud; PARA EL PUNTO 3 F
    //private double longitud;
    @JoinColumn(name = "nro_parada", referencedColumnName = "nro_parada")
    @OneToOne
    private parada parada;

    public monopatin() {
    }
    public monopatin(Time tiempo_uso, Double km_recorridos, Boolean monopatin_mantenimiento) {
        this.tiempo_uso = tiempo_uso;
        this.km_recorridos = km_recorridos;
        this.monopatin_mantenimiento = monopatin_mantenimiento;
    }
}