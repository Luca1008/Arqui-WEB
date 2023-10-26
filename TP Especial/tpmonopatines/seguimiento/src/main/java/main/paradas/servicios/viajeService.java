package main.paradas.servicios;

import main.paradas.model.viaje;
import main.paradas.repository.viajeRepository;

import java.util.List;
import java.util.Optional;

public class viajeService {
    private final viajeRepository viajeRepository;

    public viajeService(viajeRepository viajeRepository) {
        this.viajeRepository = viajeRepository;
    }

    public viaje crearViaje(viaje viaje) {
        return viajeRepository.save(viaje);
    }

    public List<viaje> obtenerTodosLosViajes() {
        return viajeRepository.findAll();
    }

    public Optional<viaje> obtenerViajePorId(Long id) {
        return viajeRepository.findById(id);
    }

    public viaje save(viaje viaje) {
        return null;
    }

    public List<viaje> findAll() {
        return null;
    }

    // Puedes agregar más métodos para realizar operaciones de negocio relacionadas con los monopatines.
}
