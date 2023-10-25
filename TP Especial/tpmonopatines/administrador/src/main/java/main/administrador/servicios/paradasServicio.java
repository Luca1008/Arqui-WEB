package com.usuarios.servicios;

import java.util.List;
import java.util.Optional;
import com.usuarios.repository.paradasRepository;

public class paradasService {
    private final paradasRepository paradasRepository;

    public paradasService(paradasRepository paradasRepository) {
        this.paradasRepository = paradasRepository;
    }

    public paradas save(paradas paradas) {
        return paradasRepository.save(paradas);
    }

    public List<paradas> obtenerTodosLosparadass() {
        return paradasRepository.findAll();
    }

    public Optional<paradas> obtenerparadasPorId(Long id) {
        return paradasRepository.findById(id);
    }
}