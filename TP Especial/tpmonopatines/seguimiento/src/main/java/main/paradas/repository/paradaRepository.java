package main.paradas.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import main.paradas.model.parada;

public interface paradaRepository extends JpaRepository<parada, Long>{
    
}
