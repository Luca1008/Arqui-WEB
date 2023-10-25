package main.mantenimiento.servicios;

import java.util.List;
import java.util.Optional;

import main.mantenimiento.model.mantenimiento;
import main.mantenimiento.repository.mantenimientoRepository;

public class mantenimientoService {
    private final mantenimientoRepository mantenimientoRepository;

    public mantenimientoService(mantenimientoRepository mantenimientoRepository) {
        this.mantenimientoRepository = mantenimientoRepository;
    }

    public mantenimiento save(mantenimiento mantenimiento) {
        return mantenimientoRepository.save(mantenimiento);
    }

    public List<mantenimiento> obtenerTodosLosMantenimientos() {
        return mantenimientoRepository.findAll();
    }

    public Optional<mantenimiento> obtenerMantenimientoPorId(Long id) {
        return mantenimientoRepository.findById(id);
    }

}
