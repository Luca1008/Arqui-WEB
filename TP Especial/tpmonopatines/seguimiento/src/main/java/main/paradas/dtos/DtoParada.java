package main.paradas.dtos;

import lombok.Data;

@Data
public class DtoParada {
    private Long id;
    private String nombre;
    private Boolean parada_permitida;
    
    public DtoParada(Long id, String nombre, Boolean parada_permitida) {
        this.id = id;
        this.nombre = nombre;
        this.parada_permitida = parada_permitida;
    }
}
