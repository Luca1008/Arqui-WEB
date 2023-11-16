package main.paradas.servicios;

import main.paradas.dtos.DtoParada;
import main.paradas.model.parada;
import main.paradas.repository.paradaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jakarta.transaction.Transactional;

@Service("paradaService")
public class paradaService {

    @Autowired
    private paradaRepository paradaRepository;
    private final RestTemplate restTemplate;

    public paradaService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Transactional
    public DtoParada save(parada parada) {
        parada resultado = paradaRepository.save(parada);
        return new DtoParada(resultado.getId(), resultado.getNombre(), resultado.getParada_permitida());
    }

    @Transactional
    public List<DtoParada> findAll() throws Exception {
        var resultados = paradaRepository.findAll();
        try {
            return resultados.stream().map(resultado -> new DtoParada(resultado.getId(), resultado.getNombre(),
                    resultado.getParada_permitida())).collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public DtoParada findById(Long id) {
        Optional<parada> res = paradaRepository.findById(id);
        if (res.isPresent()) {
            parada resultado = res.get();
            return new DtoParada(resultado.getId(), resultado.getNombre(), resultado.getParada_permitida());
        } else {
            return null;
        }

    }

    @Transactional
    public boolean deleteById(Long id) {
        Optional<parada> admin = paradaRepository.findById(id);
        if (admin.isPresent()) {
            paradaRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
