package main.mantenimiento.servicios;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jakarta.transaction.Transactional;
import main.mantenimiento.Dtos.DtoMantenimiento;
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
    public List<DtoMantenimiento> findAll() throws Exception {
        var resultados =  mantenimientoRepository.findAll();
        try {
            return resultados.stream().map(resultado -> new DtoMantenimiento(resultado.getId(),resultado.getTiempo_uso(),resultado.getKm_recorridos())).collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public DtoMantenimiento findById(Long id) {
        Optional<mantenimiento> res = mantenimientoRepository.findById(id);
        if (res.isPresent()) {
            mantenimiento resultado = res.get();
            return new DtoMantenimiento(resultado.getId(),resultado.getTiempo_uso(),resultado.getKm_recorridos());
        } else {
            return null;
        }

    }

    @Transactional
    public DtoMantenimiento save(mantenimiento mantenimiento) {
        mantenimiento resultado = mantenimientoRepository.save(mantenimiento);
        return new DtoMantenimiento(resultado.getId(),resultado.getTiempo_uso(),resultado.getKm_recorridos());
    }

    @Transactional
    public boolean deleteById(Long id) {
        Optional<mantenimiento> admin = mantenimientoRepository.findById(id);
        if (admin.isPresent()) {
            mantenimientoRepository.deleteById(id);
            return true;
        }
        else{
            return false;
        }
    }

    public String reporteDeMonopatinesKMconPausa () throws Exception{
        String url = "http://localhost:8083/monopatin/reporteKM/tiempoPausa";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        if(response.getStatusCode().is2xxSuccessful()){
            return response.getBody();
        } else {
            throw new Exception("No anduvo");
        }
    }
        public String reporteDeMonopatinesKM () throws Exception {
        String url = "http://localhost:8083/monopatin/reporteKM";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        if(response.getStatusCode().is2xxSuccessful()){
            return response.getBody();
        } else {
            throw new Exception("No anduvo");
        }
    }
}
