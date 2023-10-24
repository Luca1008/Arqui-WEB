package com.usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usuarios.model.usuario;

public interface usuarioRepository extends JpaRepository<usuario, Long> {
    
}
