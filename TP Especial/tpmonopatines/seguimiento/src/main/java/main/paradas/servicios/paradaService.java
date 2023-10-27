package main.paradas.servicios;

import main.paradas.model.parada;
import main.paradas.repository.paradaRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service("paradaService")
public class paradaService {
    
    @Autowired
    private paradaRepository paradaRepository;

    @Transactional
    public parada save(parada parada) {
        return paradaRepository.save(parada);
    }

    @Transactional
    public List<parada> findAll() {
        return paradaRepository.findAll();
    }

    @Transactional
    public Optional<parada> findById(Long id) {
        return paradaRepository.findById(id);
    }

    @Transactional
    public void deleteById(Long id) {
        paradaRepository.deleteById(id);
    }
}
