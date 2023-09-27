package com.example.demo.repository;


import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;

import com.example.demo.model.Estudiante;

public interface EstudianteRepository extends JpaRepositoryExtension<Estudiante, Long> {
    
}
