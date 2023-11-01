package main.paradas.servicios;

import main.paradas.model.viaje;
import main.paradas.repository.viajeRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service("viajeService")
public class viajeService {
    @Autowired
    private viajeRepository viajeRepository;

    @Transactional
    public viaje save(viaje viaje) {
        return viajeRepository.save(viaje);
    }

    @Transactional
    public List<viaje> findAll() {
        return viajeRepository.findAll();
    }

    @Transactional
    public Optional<viaje> obtenerViajePorId(Long id) {
        return viajeRepository.findById(id);
    }

    @Transactional
    public int calcularTotalFacturadoEnRangoDeMeses(int year, int mesInicio, int mesFin) throws Exception {
        try {
            return viajeRepository.calcularTotalFacturadoEnRangoDeMeses(year, mesInicio, mesFin);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    // para el f 2 funciones
    // @Transactional
    // public void ajustarPrecio(LocalDate fechaActual, int nuevoPrecio) {
    // viajeRepository.ajustarPrecio(fechaActual, nuevoPrecio);
    // }
}
