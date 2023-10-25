package com.usuarios.servicios;

import java.util.List;
import java.util.Optional;

import com.usuarios.repository.monopatinRepository;

public class monopatinService {
    private final monopatinRepository monopatinRepository;

    public monopatinService(monopatinRepository monopatinRepository) {
        this.monopatinRepository = monopatinRepository;
    }

    public monopatin save(monopatin monopatin) {
        return monopatinRepository.save(monopatin);
    }

    public List<monopatin> obtenerTodosLosmonopatins() {
        return monopatinRepository.findAll();
    }

    public Optional<monopatin> obtenermonopatinPorId(Long id) {
        return monopatinRepository.findById(id);
    }

}