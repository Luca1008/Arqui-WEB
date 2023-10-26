package com.paradas.servicios;

import com.paradas.model.viaje;
import com.paradas.repository.viajeRepository;

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

    // Puedes agregar más métodos para realizar operaciones de negocio relacionadas con los monopatines.
}
