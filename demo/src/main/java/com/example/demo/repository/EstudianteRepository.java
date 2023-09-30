package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;

import com.example.demo.model.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    
}
