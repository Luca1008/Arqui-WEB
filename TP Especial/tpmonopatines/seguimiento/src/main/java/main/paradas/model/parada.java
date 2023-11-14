package main.paradas.model;
import jakarta.persistence.*;
import lombok.*;



@Data
@NoArgsConstructor
@Entity
public class parada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Boolean parada_permitida = true;

    public parada(String nombre, Boolean parada_permitida){
        this.nombre=nombre;
        this.parada_permitida=parada_permitida;
    }
}
