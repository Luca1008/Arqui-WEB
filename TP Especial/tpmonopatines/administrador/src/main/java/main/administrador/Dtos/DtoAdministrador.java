package main.administrador.Dtos;

import lombok.Data;

@Data
public class DtoAdministrador {
    private int id_administrador;
    private int tarifa;
    private int tarifaPausa;
    public DtoAdministrador(int id_administrador, int tarifa, int tarifaPausa){
        this.id_administrador = id_administrador;
        this.tarifa = tarifa;
        this.tarifaPausa = tarifaPausa;

    }
}