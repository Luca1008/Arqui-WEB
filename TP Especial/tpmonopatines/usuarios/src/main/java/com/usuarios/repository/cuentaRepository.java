package com.usuarios.repository;

import com.usuarios.model.cuenta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface cuentaRepository extends JpaRepository<cuenta, Long> {


    //Anular cuentas para inhabilitar el uso momentáneo de la misma (b)
    @Modifying
    @Query("UPDATE cuenta c SET c.activada = false WHERE c.nro_cuenta = :cuentaId")
    void anularCuenta(@Param("cuentaId") Long cuentaId);
}

