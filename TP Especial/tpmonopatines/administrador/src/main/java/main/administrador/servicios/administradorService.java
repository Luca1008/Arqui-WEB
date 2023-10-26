package main.administrador.servicios;

import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;
import main.administrador.model.administrador;
import main.administrador.repository.administradorRepository;

public class administradorService {
    private final administradorRepository administradorRepository;

    public administradorService(administradorRepository administradorRepository) {
        this.administradorRepository = administradorRepository;
    }

    @Transactional
    public List<administrador> findAll() {
        return administradorRepository.findAll();
    }

    @Transactional
    public Optional<administrador> findById(Long id) {
        return administradorRepository.findById(id);
    }

    @Transactional
    public administrador save(administrador administrador) {
        return administradorRepository.save(administrador);
    }

    @Transactional
    public administrador update(Long id, administrador administrador) {
        return null;
    }

    @Transactional
    public void deleteById(Long id) {
        administradorRepository.deleteById(id);
    }

}