package main.mantenimiento.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jakarta.transaction.Transactional;
import main.mantenimiento.model.mantenimiento;
import main.mantenimiento.repository.mantenimientoRepository;

@Service("mantenimientoService")
public class mantenimientoService {
    @Autowired
    private mantenimientoRepository mantenimientoRepository;
    private final RestTemplate restTemplate;

    public mantenimientoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Transactional
    public List<mantenimiento> findAll() {
        return mantenimientoRepository.findAll();
    }

    @Transactional
    public Optional<mantenimiento> findById(Long id) {
        return mantenimientoRepository.findById(id);
    }

    @Transactional
    public mantenimiento save(mantenimiento mantenimiento) {
        return mantenimientoRepository.save(mantenimiento);
    }

    @Transactional
    public mantenimiento update(Long id, mantenimiento mantenimiento) {
        return null;
    }

    @Transactional
    public void deleteById(Long id) {
        mantenimientoRepository.deleteById(id);
    }

    public String reporteDeMonopatinesKMconPausa () throws Exception{
        String url = "http://localhost:8083/monopatin/reporteKM/tiempoPausa/";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        if(response.getStatusCode().is2xxSuccessful()){
            return response.getBody();
        } else {
            throw new Exception("No anduvo");
        }
    }
        public String reporteDeMonopatinesKM () throws Exception {
        String url = "http://localhost:8083/monopatin/reporteKM/";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        if(response.getStatusCode().is2xxSuccessful()){
            return response.getBody();
        } else {
            throw new Exception("No anduvo");
        }
    }
}
