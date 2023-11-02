package main.paradas.dtos;

import lombok.Data;

@Data
public class DtoParada {
    private Long nro_parada;
    private String nombre;
    private Boolean parada_permitida;
    
    public DtoParada(Long nro_parada, String nombre, Boolean parada_permitida) {
        this.nro_parada = nro_parada;
        this.nombre = nombre;
        this.parada_permitida = parada_permitida;
    }
}
