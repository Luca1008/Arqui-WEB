package main.paradas.servicios;

import main.paradas.model.monopatin;
import main.paradas.repository.monopatinRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service("monopatinService")
public class monopatinService {
    @Autowired
    private monopatinRepository monopatinRepository;

    @Transactional
    public monopatin save(monopatin monopatin) {
        return monopatinRepository.save(monopatin);
    }

    @Transactional
    public List<monopatin> findAll() {
        return monopatinRepository.findAll();
    }

    @Transactional
    public Optional<monopatin> findById(Long id) {
        return monopatinRepository.findById(id);
    }

    @Transactional
    public monopatin updateMonopatin(Long id, monopatin monopatin) {
        return monopatinRepository.save(monopatin);
    }

    @Transactional
    public void deleteById(Long id) {
        monopatinRepository.deleteById(id);
    }

     @Transactional
     public List<monopatin> generarReporteKm(boolean tiempoDePausa) {
         return monopatinRepository.reporteKm(tiempoDePausa);
     }

     @Transactional
     public List<monopatin> buscarMonopatinesConMasDeXViajesEnAnio(int year, int numViajes) {
         return monopatinRepository.buscarMonopatinesConMasDeXViajesEnAnio(year, numViajes);
     }

    // @Transactional
    // public int monopatinesEnOperacionOEnMantenimiento(Boolean enMantenimiento) {
    //     return monopatinRepository.monopatinesEnOperacionOEnMantenimiento(enMantenimiento);
    // }

    // @Transactional
    // public List<monopatin> monopatinesCercanos(int latitud, int longuitud, int maxDistancia) {
    //     return monopatinRepository.monopatinesCercanos(latitud, longuitud, maxDistancia);
    // }
}
