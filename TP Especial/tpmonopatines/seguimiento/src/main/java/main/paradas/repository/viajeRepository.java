package main.paradas.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import main.paradas.model.viaje;

public interface viajeRepository extends JpaRepository<viaje, Long>{

//     //Consultar el total facturado en un rango de meses de cierto año (d)
//     @Query("SELECT SUM(v.precio) FROM viaje v " +
//            "WHERE YEAR(v.fecha_inicio) = :year " +
//            "AND MONTH(v.fecha_inicio) BETWEEN :mesInicio AND :mesFin")
//     Double calcularTotalFacturadoEnRangoDeMeses(@Param("year") int year, @Param("mesInicio") int mesInicio, @Param("mesFin") int mesFin);


//     //quiero hacer un ajuste de precios, y que a partir de cierta fecha el sistema habilite los nuevos precios.
//     //(f)
//     @Query("SELECT v FROM viaje v " +
//            "WHERE v.fechaHabilitacionNuevosPrecios <= :fechaEspecifica " +
//            "AND v.precio <> :nuevoPrecio")
//     List<viaje> findViajesConNuevosPreciosHabilitados(@Param("fechaEspecifica") LocalDate fechaEspecifica);


//     //para el punto 3 f
//     @Modifying
//     @Query("UPDATE viaje v SET v.precio = :nuevoPrecio, WHERE v.fechaHabilitacionNuevosPrecios <= :fechaActual")
//     void ajustarPrecio(@Param("fechaActual") LocalDate fechaActual, @Param("nuevoPrecio") int nuevoPrecio);

}
