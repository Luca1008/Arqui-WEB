package main.paradas.servicios;

import main.paradas.model.parada;
import main.paradas.repository.paradaRepository;

import java.util.List;
import java.util.Optional;

public class paradaService {
    private final paradaRepository paradaRepository;

    public paradaService(paradaRepository paradaRepository) {
        this.paradaRepository = paradaRepository;
    }

    public parada save(parada parada) {
        return paradaRepository.save(parada);
    }

    public List<parada> findAll() {
        return paradaRepository.findAll();
    }

    public Optional<parada> findById(Long id) {
        return paradaRepository.findById(id);
    }

    public void deleteById(Long id) {
        paradaRepository.deleteById(id);
    }
}
