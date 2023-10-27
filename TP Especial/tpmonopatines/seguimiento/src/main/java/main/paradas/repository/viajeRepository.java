package main.paradas.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import main.paradas.model.viaje;

public interface viajeRepository extends JpaRepository<viaje, Long>{

    //Consultar el total facturado en un rango de meses de cierto año (d)
    @Query("SELECT SUM(v.precio) FROM viaje v " +
           "WHERE YEAR(v.fecha_inicio) = :year " +
           "AND MONTH(v.fecha_inicio) BETWEEN :mesInicio AND :mesFin")
    Double calcularTotalFacturadoEnRangoDeMeses(@Param("year") int year, 
                                                    @Param("mesInicio") int mesInicio, 
                                                    @Param("mesFin") int mesFin);

}
