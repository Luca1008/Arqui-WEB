package main.paradas.model;

import java.sql.Time;
import jakarta.persistence.*;
import lombok.*; 
@Data
@Entity
public class monopatin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Time tiempo_uso;
    private int km_recorridos; 
    private short monopatin_mantenimiento;
    //private double latitud; PARA EL PUNTO 3 F
    //private double longitud;
    @OneToMany
    private parada nro_parada;



    public monopatin() {
    }




    public monopatin(Time tiempo_uso, int km_recorridos, short monopatin_mantenimiento, parada nro_parada) {
        this.tiempo_uso = tiempo_uso;
        this.km_recorridos = km_recorridos;
        this.monopatin_mantenimiento = monopatin_mantenimiento;
        this.nro_parada = nro_parada;
    }
}