package main.paradas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import main.paradas.model.monopatin;

public interface monopatinRepository extends JpaRepository<monopatin, Long>{

    @Query("SELECT m.id,m.km_recorridos FROM monopatin m")
    List<Object[]> reporteKm();

    @Query("SELECT m.id,m.km_recorridos,SEC_TO_TIME(SUM(TIME_TO_SEC(v.pausa))) AS pausa FROM monopatin m JOIN viaje v ON v.monopatin.id = m.id GROUP BY m.id,m.km_recorridos")
    List<Object[]> generarReporteKmPausa();
    

	//Los monopatines con más de x viajes en un cierto año (c)
    @Query("SELECT m FROM monopatin m JOIN viaje v ON m.id = v.monopatin.id WHERE YEAR(v.fecha_inicio) = :year GROUP BY m.id HAVING COUNT(v.id) > :numViajes")
    List<monopatin> buscarMonopatinesConMasDeXViajesEnAnio(@Param("year") int year, @Param("numViajes") int numViajes);

    
    //consultar la cantidad de monopatines actualmente en operación, vs la cantidad de monopatines actualmente en mantenimiento
    @Query("SELECT m.monopatin_mantenimiento, COUNT(*) AS cantidad FROM monopatin m GROUP BY m.monopatin_mantenimiento")
    List<Object[]> monopatinesEnOperacionOEnMantenimiento();
    
    // //listado de los monopatines cercanos a mi zona, para poder encontrar un monopatín cerca de mi ubicación (f)
   
    @Query("SELECT m.id, m.x, m.y, SQRT((m.x - :x) * (m.x - :x) + (m.y - :y) * (m.y - :y)) AS distancia FROM monopatin m WHERE SQRT((m.x - :x) * (m.x - :x) + (m.y - :y) * (m.y - :y)) <= :maxDistance ORDER BY distancia")
    List<Object[]> getMonopatinCercanos(@Param("x") int x, @Param("y") int y, @Param("maxDistance") int maxDistance);

}
