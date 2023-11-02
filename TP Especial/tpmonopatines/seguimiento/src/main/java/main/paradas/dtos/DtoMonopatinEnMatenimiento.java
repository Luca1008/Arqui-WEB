package main.paradas.dtos;

import lombok.Data;

@Data
public class DtoMonopatinEnMatenimiento {
    private Boolean EnMantenimiento;
    private Long Cantidad;

    public DtoMonopatinEnMatenimiento(Object EnMantenimiento, Object Cantidad) {
        this.EnMantenimiento = (Boolean) EnMantenimiento;
        this.Cantidad = (Long) Cantidad;
    }
} 