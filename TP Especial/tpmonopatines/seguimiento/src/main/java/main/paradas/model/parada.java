package main.paradas.model;
import jakarta.persistence.*;
import lombok.*;
@Data
@Entity
public class parada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nro_parada;
    private String nombre;
    private Boolean parada_permitida;
    
    public parada() {
    }

    public parada(String nombre, Boolean parada_permitida){
        this.nombre=nombre;
        this.parada_permitida=parada_permitida;

    }

}
