package com.usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usuarios.model.autoridad;

public interface autoridadRepository extends JpaRepository<autoridad, String> {
}
