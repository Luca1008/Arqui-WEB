package main.paradas.dtos;


import lombok.Data;

@Data
public class DtoMonopatinDistancia {
    private Long id;
    private int x;
    private int y;
    private Double distancia;

    public DtoMonopatinDistancia(Object id, Object x, Object y, Object distancia) {
        this.id = (Long) id;
        this.x = (int) x;
        this.y = (int) y;
        this.distancia = (Double) distancia;
    }
}
