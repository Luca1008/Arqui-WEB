package main.paradas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import main.paradas.model.monopatin;

public interface monopatinRepository extends JpaRepository<monopatin, Long>{
     
    // //Reporte por km con y sin pausa (a)
    // @Query("SELECT m FROM monopatin m WHERE :incluirTiempoDePausa = true OR m.tiempoDePausa = 0")
    // List<monopatin> reporteKm(@Param("incluirTiempoDePausa") boolean tiempoDePausa);

	// //Los monopatines con más de X viajes en un cierto año (c)
    // @Query("SELECT m FROM monopatin m JOIN FETCH m.viaje v WHERE YEAR(v.fecha_inicio) = :year GROUP BY m HAVING COUNT(v) > :numViajes")
    // List<monopatin> buscarMonopatinesConMasDeXViajesEnAnio(@Param("year") int year, @Param("numViajes") int numViajes);

    // //consultar la cantidad de monopatines actualmente en operación, vs la cantidad de monopatines actualmente en mantenimiento
    // //(e)
    // @Query("SELECT COUNT(m) FROM monopatin m WHERE m.monopatin_mantenimiento = :mantenimiento")
    // int monopatinesEnOperacionOEnMantenimiento(@Param ("mantenimiento") Boolean enMantenimiento);

    // //listado de los monopatines cercanos a mi zona, para poder encontrar un monopatín cerca de mi ubicación (f)
    // //(g) 
    // @Query("SELECT m FROM monopatin m " +
    //        "WHERE FUNCTION('ACOS', FUNCTION('SIN', :userLatitud) * FUNCTION('SIN', m.latitud) + " +
    //        "FUNCTION('COS', :userLatitud) * FUNCTION('COS', m.latitud) * FUNCTION('COS', :userLongitud - m.longitud)) * 6371 <= :maxDistance")
    // List<monopatin> monopatinesCercanos (@Param("userLatitud") double userLatitud, @Param("userLongitud") double userLongitud, @Param("maxDistance") double maxDistance);
}
