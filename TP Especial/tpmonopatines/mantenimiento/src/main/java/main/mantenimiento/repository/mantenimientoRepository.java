package main.mantenimiento.repository;

import main.mantenimiento.model.mantenimiento;

import org.springframework.data.jpa.repository.JpaRepository;

public interface mantenimientoRepository extends JpaRepository<mantenimiento, Long> {
}

