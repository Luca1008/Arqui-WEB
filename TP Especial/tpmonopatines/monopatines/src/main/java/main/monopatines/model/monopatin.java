package main.monopatines.model;
import java.util.Set;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "Monopatin")
public class Monopatin {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_monopatin;

    private LocalDate fechaRegistro;
}