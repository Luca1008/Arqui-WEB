package main.mantenimiento.repository.mongodb;


import org.springframework.data.mongodb.repository.MongoRepository;
import main.mantenimiento.model.mongodb.mantenimiento;
import org.springframework.stereotype.Repository;

@Repository
public interface mantenimientoRepository extends MongoRepository<mantenimiento, Long> {
}

