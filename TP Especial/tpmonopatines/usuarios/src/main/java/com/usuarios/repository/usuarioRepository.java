package com.usuarios.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usuarios.model.usuario;

public interface usuarioRepository extends JpaRepository<usuario, Long> {

    Optional<usuario> findUsuarioByEmailIgnoreCase(String email);

    boolean existsUsuariosByEmailIgnoreCase(String email );

}
