package com.usuarios.repository;

import com.usuarios.model.cuenta;

import org.springframework.data.jpa.repository.JpaRepository;

public interface cuentaRepository extends JpaRepository<cuenta, Long> {
}

