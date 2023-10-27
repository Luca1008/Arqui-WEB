package main.paradas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import main.paradas.model.monopatin;

public interface monopatinRepository extends JpaRepository<monopatin, Long>{
     
     //Reporte por km con y sin pausa (a)
	
    @Query("SELECT m FROM monopatin m WHERE :incluirTiempoDePausa = true OR m.tiempoDePausa = 0")
    List<monopatin> reporteKm(@Param("incluirTiempoDePausa") boolean tiempoDePausa);

	//Los monopatines con más de X viajes en un cierto año (c)
    @Query("SELECT m FROM monopatin m JOIN FETCH m.viaje v WHERE YEAR(v.fecha_inicio) = :year GROUP BY m HAVING COUNT(v) > :numViajes")
    List<monopatin> buscarMonopatinesConMasDeXViajesEnAnio(@Param("year") int year, @Param("numViajes") int numViajes);

}
