package main.paradas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import main.paradas.model.parada;

public interface paradaRepository extends JpaRepository<parada, Long>{
    
}
