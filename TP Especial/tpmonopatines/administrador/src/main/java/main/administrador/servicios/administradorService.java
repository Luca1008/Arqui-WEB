package main.administrador.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jakarta.transaction.Transactional;
import main.administrador.model.administrador;
import main.administrador.repository.administradorRepository;


@Service("administradorService")
public class administradorService {

    @Autowired
    private administradorRepository administradorRepository;
    private final RestTemplate restTemplate;


    public administradorService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Transactional
    public List<administrador> findAll() {
        return administradorRepository.findAll();
    }

    @Transactional
    public Optional<administrador> findById(Long id) {
        return administradorRepository.findById(id);
    }

    @Transactional
    public administrador save(administrador administrador) {
        return administradorRepository.save(administrador);
    }

    @Transactional
    public administrador update(Long id, administrador administrador) {
        return null;
    }

    @Transactional
    public boolean deleteById(Long id) {
        Optional<administrador> admin = administradorRepository.findById(id);
        if (admin.isPresent()) {
            administradorRepository.deleteById(id);
            return true;
        }
        else{
            return false;
        }
    }

    public String hacerLlamadaAlOtroServicio(Long id) throws Exception {
        
        String url = "http://localhost:8084/cuentas/anular/" + id;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            throw new Exception("No anduvo");
        }
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