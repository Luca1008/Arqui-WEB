package main.paradas.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import main.paradas.model.viaje;

public interface viajeRepository extends JpaRepository<viaje, Long>{

     //Consultar el total facturado en un rango de meses de cierto año (d)
    @Query("SELECT SUM(v.precio) FROM viaje v " +
           "WHERE YEAR(v.fecha_inicio) = :year " +
           "AND MONTH(v.fecha_inicio) BETWEEN :mesInicio AND :mesFin")
    int calcularTotalFacturadoEnRangoDeMeses(int year,int mesInicio,int mesFin);


}
