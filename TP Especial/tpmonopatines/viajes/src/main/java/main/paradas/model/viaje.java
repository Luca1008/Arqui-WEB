package main.paradas.model;
@Data
@Entity
public class viaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    public viaje() {
    }

    public viaje(String nombre, String apellido, int celular, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.email = email;
    }
}