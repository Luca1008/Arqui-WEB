package main.paradas.servicios;

import main.paradas.model.viaje;
import main.paradas.repository.viajeRepository;

import java.time.LocalDate;
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
    public double calcularTotalFacturadoEnRangoDeMeses(int year, int mesInicio, int mesFin){
        return viajeRepository.calcularTotalFacturadoEnRangoDeMeses(year, mesInicio, mesFin);
    }
    //para el f 2 funciones
    public void ajustarPrecio(LocalDate fechaActual, int nuevoPrecio){
        viajeRepository.ajustarPrecio(fechaActual, nuevoPrecio);
    }
}
