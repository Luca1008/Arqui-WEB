package com.paradas.servicios;

import com.paradas.model.monopatin;
import com.paradas.repository.monopatinRepository;

import java.util.List;
import java.util.Optional;

public class monopatinService {
    private final monopatinRepository monopatinRepository;

    public monopatinService(monopatinRepository monopatinRepository) {
        this.monopatinRepository = monopatinRepository;
    }

    public monopatin crearmonopatin(monopatin monopatin) {
        return monopatinRepository.save(monopatin);
    }

    public List<monopatin> obtenerTodosLosmonopatines() {
        return monopatinRepository.findAll();
    }

    public Optional<monopatin> obtenermonopatinPorId(Long id) {
        return monopatinRepository.findById(id);
    }

    // Puedes agregar más métodos para realizar operaciones de negocio relacionadas con los monopatines.
}
