package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.CarreraEstudiante;

public interface CERepository extends JpaRepository<CarreraEstudiante, Long> {
        
}
