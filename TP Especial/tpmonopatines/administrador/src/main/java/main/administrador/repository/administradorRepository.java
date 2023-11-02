package main.administrador.repository;

import main.administrador.model.administrador;

import org.springframework.data.jpa.repository.*;

public interface administradorRepository extends JpaRepository<administrador, Long> {

    // @Query("")
    // void setTarifasEnXfecha(int year, int mes, int day, int tarifa);
    
}