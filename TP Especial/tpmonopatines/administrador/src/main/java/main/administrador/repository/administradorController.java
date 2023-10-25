package main.administrador.repository;

import main.administrador.model.administrador;

import org.springframework.data.jpa.repository.JpaRepository;

public interface cuentaRepository extends JpaRepository<cuenta, Long> {
    // Aquí puedes poner tus consultas personalizadas a la base de datos
    
}