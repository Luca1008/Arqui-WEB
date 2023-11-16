package main.administrador.Dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DtoAdministrador {

    private int id;
    private int tarifa;
    private int tarifaPausa;

    public DtoAdministrador(int id, int tarifa, int tarifaPausa) {
        this.id = id;
        this.tarifa = tarifa;
        this.tarifaPausa = tarifaPausa;

    }
}