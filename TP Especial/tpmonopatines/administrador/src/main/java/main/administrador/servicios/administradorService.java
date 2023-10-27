package main.administrador.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import main.administrador.model.administrador;
import main.administrador.repository.administradorRepository;

@Service("administradorService")
public class administradorService {

    @Autowired
    private administradorRepository administradorRepository;

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