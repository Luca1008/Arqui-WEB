package main.administrador.repository;

import main.administrador.model.administrador;

import org.springframework.data.jpa.repository.JpaRepository;

public interface administradorRepository extends JpaRepository<administrador, Long> {
    // Aquí puedes poner tus consultas personalizadas a la base de datos
    
}