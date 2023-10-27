package main.paradas.servicios;

import main.paradas.model.monopatin;
import main.paradas.repository.monopatinRepository;

import java.util.List;
import java.util.Optional;

public class monopatinService {
    private final monopatinRepository monopatinRepository;

    public monopatinService(monopatinRepository monopatinRepository) {
        this.monopatinRepository = monopatinRepository;
    }

    public monopatin crearMonopatin(monopatin monopatin) {
        return monopatinRepository.save(monopatin);
    }

    public List<monopatin> obtenerTodosLosMonopatines() {
        return monopatinRepository.findAll();
    }

    public Optional<monopatin> obtenermonopatinPorId(Long id) {
        return monopatinRepository.findById(id);
    }

    public List<monopatin> findAll() {
        return null;
    }

    public monopatin save(monopatin monopatin) {
        return null;
    }
    public List<monopatin> generarReporteKm(boolean tiempoDePausa) {
        return monopatinRepository.reporteKm(tiempoDePausa);
    }

    public List<monopatin> buscarMonopatinesConMasDeXViajesEnAnio(int year, int numViajes){
        return monopatinRepository.buscarMonopatinesConMasDeXViajesEnAnio(year,numViajes);
    }
    public int monopatinesEnOperacionOEnMantenimiento(short enMantenimiento){
        return monopatinRepository.monopatinesEnOperacionOEnMantenimiento(enMantenimiento);
    }
    public List<monopatin> monopatinesCercanos(int latitud,int longuitud, int maxDistancia){
        return monopatinRepository.monopatinesCercanos(latitud, longuitud, maxDistancia);
    }
}
