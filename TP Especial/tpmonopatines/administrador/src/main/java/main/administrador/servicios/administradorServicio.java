package com.administrador.servicios;

import java.util.List;
import java.util.Optional;

import com.administrador.model.administrador;
import com.administrador.repository.administradorRepository;

public class administradorService {
    private final administradorRepository administradorRepository;

    public administradorService(administradorRepository administradorRepository) {
        this.administradorRepository = administradorRepository;
    }

    public administrador save(administrador administrador) {
        return administradorRepository.save(administrador);
    }

    public List<administrador> obtenerTodosLosadministradors() {
        return administradorRepository.findAll();
    }

    public Optional<administrador> obteneradministradorPorId(Long id) {
        return administradorRepository.findById(id);
    }

}