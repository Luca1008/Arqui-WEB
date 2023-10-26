package main.mantenimiento.servicios;

import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;
import main.mantenimiento.model.mantenimiento;
import main.mantenimiento.repository.mantenimientoRepository;

public class mantenimientoService {
    private final mantenimientoRepository mantenimientoRepository;

    public mantenimientoService(mantenimientoRepository mantenimientoRepository) {
        this.mantenimientoRepository = mantenimientoRepository;
    }

    @Transactional
    public List<mantenimiento> findAll() {
        return mantenimientoRepository.findAll();
    }

    @Transactional
    public Optional<mantenimiento> findById(Long id) {
        return mantenimientoRepository.findById(id);
    }

    @Transactional
    public mantenimiento save(mantenimiento mantenimiento) {
        return mantenimientoRepository.save(mantenimiento);
    }

    @Transactional
    public mantenimiento update(Long id, mantenimiento mantenimiento) {
        return null;
    }

    @Transactional
    public void deleteById(Long id) {
        mantenimientoRepository.deleteById(id);
    }
}
