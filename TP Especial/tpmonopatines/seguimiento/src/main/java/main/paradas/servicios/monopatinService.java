package main.paradas.servicios;

import main.paradas.dtos.DtoMonopatinEnMatenimiento;
import main.paradas.dtos.DtoMonopatinKm;
import main.paradas.dtos.DtoMonopatinKmPausa;
import main.paradas.model.monopatin;
import main.paradas.repository.monopatinRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<DtoMonopatinKm> generarReporteKm() throws Exception {
        var resultados = monopatinRepository.generarReporteKmPausa();
        try {
            return resultados.stream().map(resultado -> new DtoMonopatinKm(resultado[0], resultado[1]))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<DtoMonopatinKmPausa> generarReporteKmConPausa() throws Exception {
        var resultados = monopatinRepository.generarReporteKmPausa();
        try {
            return resultados.stream().map(resultado -> new DtoMonopatinKmPausa(resultado[0], resultado[1], resultado[2]))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

	public List<DtoMonopatinEnMatenimiento> monopatinesEnOperacionOEnMantenimiento() throws Exception {
        var resultados = monopatinRepository.monopatinesEnOperacionOEnMantenimiento();
        try {
            return resultados.stream().map(resultado -> new DtoMonopatinEnMatenimiento(resultado[0], resultado[1]))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
	}

    @Transactional
    public List<monopatin> buscarMonopatinesConMasDeXViajesEnAnio(int year, int numViajes) {
        return monopatinRepository.buscarMonopatinesConMasDeXViajesEnAnio(year, numViajes);
    }

    // @Transactional
    // public List<monopatin> monopatinesCercanos(int latitud, int longuitud, int
    // maxDistancia) {
    // return monopatinRepository.monopatinesCercanos(latitud, longuitud,
    // maxDistancia);
    // }
}
