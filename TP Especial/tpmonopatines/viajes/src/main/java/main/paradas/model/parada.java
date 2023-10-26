package main.paradas.model;
import jakarta.persistence.*;
import lombok.*;
@Data
@Entity
public class parada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    public parada() {
    }

}
