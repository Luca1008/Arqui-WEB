package com.paradas.servicios;

import com.paradas.model.parada;
import com.paradas.repository.paradaRepository;

import java.util.List;
import java.util.Optional;

public class paradaService {
    private final paradaRepository paradaRepository;

    public paradaService(paradaRepository paradaRepository) {
        this.paradaRepository = paradaRepository;
    }

    public parada crearParada(parada parada) {
        return paradaRepository.save(parada);
    }

    public List<parada> obtenerTodasLasParadas() {
        return paradaRepository.findAll();
    }

    public Optional<parada> obtenerParadaPorId(Long id) {
        return paradaRepository.findById(id);
    }

    // Puedes agregar más métodos para realizar operaciones de negocio relacionadas con los monopatines.
}
