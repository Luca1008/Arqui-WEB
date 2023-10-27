package com.usuarios.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usuarios.model.cuenta;
import com.usuarios.repository.cuentaRepository;

import jakarta.transaction.Transactional;

@Service("cuentaService")
public class cuentaService {
    @Autowired
    private final cuentaRepository cuentaRepository;

    public cuentaService(cuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    @Transactional
    public cuenta save(cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    @Transactional
    public List<cuenta> obtenerTodosLoscuentas() {
        return cuentaRepository.findAll();
    }

    @Transactional
    public cuenta obtenerCuentaPorId(Long cuentaId) throws Exception {
        try {
            Optional<cuenta> resultado = cuentaRepository.findById(cuentaId);
            cuenta cuenta = resultado.get();
            return cuenta;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public cuenta modificarCuentaPorId(Long cuentaId) {
        return null;
    }

    @Transactional
    public void eliminarCuentaPorId(Long cuentaId) {
        cuentaRepository.deleteById(cuentaId);
    }

     @Transactional
    public void anularCuenta(long cuentaId){
        cuentaRepository.anularCuenta(cuentaId);
    }
}
