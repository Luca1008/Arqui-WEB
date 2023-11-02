package main.administrador.servicios;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jakarta.transaction.Transactional;
import main.administrador.Dtos.DtoAdministrador;
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
    public List<DtoAdministrador> findAll() throws Exception {
        var resultados = administradorRepository.findAll();
        try {
            return resultados.stream().map(resultado -> new DtoAdministrador(resultado.getId_administrador(),
                    resultado.getTarifa(), resultado.getTarifaPausa())).collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public DtoAdministrador findById(Long id) {
        Optional<administrador> res = administradorRepository.findById(id);
        if (res.isPresent()) {
            administrador resultado = res.get();
            return new DtoAdministrador(resultado.getId_administrador(), resultado.getTarifa(), resultado.getTarifaPausa());
        } else {
            return null;
        }
    }

    @Transactional
    public DtoAdministrador save(administrador administrador) {
        administrador resultado = administradorRepository.save(administrador);
        return new DtoAdministrador(resultado.getId_administrador(), resultado.getTarifa(), resultado.getTarifaPausa());
    }

    @Transactional
    public DtoAdministrador update(Long id, administrador administrador) {
        administrador resultado = administradorRepository.save(administrador);
        return new DtoAdministrador(resultado.getId_administrador(), resultado.getTarifa(), resultado.getTarifaPausa());
    }

    @Transactional
    public boolean deleteById(Long id) {
        Optional<administrador> admin = administradorRepository.findById(id);
        if (admin.isPresent()) {
            administradorRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    // public void actualizarTarifasEnXfecha(int year, int mes, int day, int tarifa)
    // throws Exception {
    // try {
    // administradorRepository.setTarifasEnXfecha(year,mes,day,tarifa);
    // } catch (Exception e) {
    // throw new Exception("No anduvo");
    // }

    // }

    public String anularCuenta(Long id) throws Exception {

        String url = "http://localhost:8084/cuentas/anular/" + id;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            throw new Exception("No anduvo");
        }
    }

    public String facturadoEntreMesesdeXaño (int year, int mesInicio, int mesFin) throws Exception {
        String url = "http://localhost:8083/viaje/CalcularTotal/year/"+year+"/mesInicio/"+mesInicio+"/mesFin/"+mesFin;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            throw new Exception("No anduvo");
        }
    }

    public String monopatinesConXviajesEnXaño (int year, int numViajes) throws Exception {
        String url = "http://localhost:8083/monopatin/buscar/year/"+year+"/viajes/"+numViajes;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            throw new Exception("No anduvo");
        }
    }

    public String monopatinesEnFuncionamientoVsMantenimiento() throws Exception {
        String url = "http://localhost:8083/monopatin/monopatinesEnOperacionOEnMantenimiento";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            throw new Exception("No anduvo");
        }
    }

}