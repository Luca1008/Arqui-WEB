package main.administrador.Dtos;

import lombok.Data;

@Data
public class DtoAdministrador {
    private int id;
    private int tarifa;
    private int tarifaPausa;
    public DtoAdministrador(int id, int tarifa, int tarifaPausa){
        this.id = id;
        this.tarifa = tarifa;
        this.tarifaPausa = tarifaPausa;

    }
}