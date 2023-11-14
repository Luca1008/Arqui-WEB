package com.usuarios.servicios;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usuarios.Dtos.DtoCuenta;
import com.usuarios.model.cuenta;
import com.usuarios.repository.cuentaRepository;

import jakarta.transaction.Transactional;

@Service("cuentaService")
public class cuentaService {

    @Autowired
    private cuentaRepository cuentaRepository;

    @Transactional
    public DtoCuenta save(cuenta cuenta) throws Exception {
        cuenta resultado = cuentaRepository.save(cuenta);
        return new DtoCuenta(resultado.getId(), resultado.getDinero(), resultado.getFechaAlta(), resultado.getActivada(), resultado.getUsuarios());
    }

    @Transactional
    public List<DtoCuenta> findAll() throws Exception {
        var resultados =  cuentaRepository.findAll();
        try {
            return resultados.stream().map(resultado -> new DtoCuenta(resultado.getId(), resultado.getDinero(), resultado.getFechaAlta(), resultado.getActivada(), resultado.getUsuarios())).collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public DtoCuenta findById(Long id) throws Exception {
        try {
            Optional<cuenta> res = cuentaRepository.findById(id);
            if (res.isPresent()) {
                cuenta resultado = res.get();
                return new DtoCuenta(resultado.getId(), resultado.getDinero(), resultado.getFechaAlta(), resultado.getActivada(), resultado.getUsuarios());
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    @Transactional
    public Boolean anularCuenta(long cuentaId){
        if(!cuentaRepository.existsById(cuentaId)){
            return false;
        }
        else {
            cuentaRepository.anularCuenta(cuentaId);
            return true;
        }
    }

    @Transactional
    public Boolean deleteById(Long cuentaId) {
        Optional<cuenta> admin = cuentaRepository.findById(cuentaId);
        if (admin.isPresent()) {
            cuentaRepository.deleteById(cuentaId);
            return true;
        } else {
            return false;
        }
    }


}
