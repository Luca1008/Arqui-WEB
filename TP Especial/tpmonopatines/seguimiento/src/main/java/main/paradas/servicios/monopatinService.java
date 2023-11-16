package main.paradas.servicios;

import main.paradas.dtos.DtoMonopatin;
import main.paradas.dtos.DtoMonopatinDistancia;
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
import org.springframework.web.client.RestTemplate;

import jakarta.transaction.Transactional;

@Service("monopatinService")
public class monopatinService {
    @Autowired
    private monopatinRepository monopatinRepository;
    private final RestTemplate restTemplate;

    public monopatinService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Transactional
    public DtoMonopatin save(monopatin monopatin) {
        var resultado = monopatinRepository.save(monopatin);
        return new DtoMonopatin(resultado.getId(), resultado.getTiempo_uso(), resultado.getKm_recorridos(),
                resultado.getMonopatin_mantenimiento(), resultado.getX(), resultado.getY(), resultado.getParada());
    }

    @Transactional
    public List<DtoMonopatin> findAll() throws Exception {
        var resultados = monopatinRepository.findAll();
        try {
            return resultados.stream()
                    .map(resultado -> new DtoMonopatin(resultado.getId(), resultado.getTiempo_uso(),
                            resultado.getKm_recorridos(), resultado.getMonopatin_mantenimiento(), resultado.getX(),
                            resultado.getY(), resultado.getParada()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public DtoMonopatin findById(Long id) {
        Optional<monopatin> res = monopatinRepository.findById(id);
        if (res.isPresent()) {
            monopatin resultado = res.get();
            return new DtoMonopatin(resultado.getId(), resultado.getTiempo_uso(), resultado.getKm_recorridos(),
                    resultado.getMonopatin_mantenimiento(), resultado.getX(), resultado.getY(), resultado.getParada());
        } else {
            return null;
        }
    }

    @Transactional
    public boolean deleteById(Long id) {
        Optional<monopatin> admin = monopatinRepository.findById(id);
        if (admin.isPresent()) {
            monopatinRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
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
            return resultados.stream()
                    .map(resultado -> new DtoMonopatinKmPausa(resultado[0], resultado[1], resultado[2]))
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
    public List<DtoMonopatin> buscarMonopatinesConMasDeXViajesEnAnio(int year, int numViajes) throws Exception {
        var resultados = monopatinRepository.buscarMonopatinesConMasDeXViajesEnAnio(year, numViajes);
        try {
            return resultados.stream()
                    .map(resultado -> new DtoMonopatin(resultado.getId(), resultado.getTiempo_uso(),
                            resultado.getKm_recorridos(), resultado.getMonopatin_mantenimiento(), resultado.getX(),
                            resultado.getY(), resultado.getParada()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<DtoMonopatinDistancia> getMonopatinCercanos(int userLatitud, int userLongitud, int maxDistance)
            throws Exception {
        var resultados = monopatinRepository.getMonopatinCercanos(userLatitud, userLongitud, maxDistance);
        try {
            return resultados.stream()
                    .map(resultado -> new DtoMonopatinDistancia(resultado[0], resultado[1], resultado[2], resultado[3]))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
