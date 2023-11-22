package main.mantenimiento.repository;

import main.mantenimiento.model.mantenimiento;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface mantenimientoRepository extends MongoRepository<mantenimiento, String> {
    Optional<mantenimiento> findById(String id);

    void deleteById(String id);
}

