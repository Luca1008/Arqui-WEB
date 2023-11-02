package main.paradas.dtos;


import lombok.Data;

@Data
public class DtoMonopatinDistancia {
    private Long id_monopatin;
    private int x;
    private int y;
    private Double distancia;

    public DtoMonopatinDistancia(Object id_monopatin, Object x, Object y, Object distancia) {
        this.id_monopatin = (Long) id_monopatin;
        this.x = (int) x;
        this.y = (int) y;
        this.distancia = (Double) distancia;
    }
}
