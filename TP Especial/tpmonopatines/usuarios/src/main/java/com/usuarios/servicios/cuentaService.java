package com.usuarios.servicios;

import java.util.List;
import java.util.Optional;

import com.usuarios.model.cuenta;
import com.usuarios.repository.cuentaRepository;

public class cuentaService {
    private final cuentaRepository cuentaRepository;

    public cuentaService(cuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    public cuenta save(cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    public List<cuenta> obtenerTodosLoscuentas() {
        return cuentaRepository.findAll();
    }

    public Optional<cuenta> obtenercuentaPorId(Long id) {
        return cuentaRepository.findById(id);
    }

    public cuenta obtenerCuentaPorId(Long cuentaId) {
        return null;
    }
}
