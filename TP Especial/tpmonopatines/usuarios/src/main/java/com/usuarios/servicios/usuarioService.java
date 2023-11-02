package com.usuarios.servicios;

import com.usuarios.Dtos.DtoUsuario;
import com.usuarios.model.usuario;
import com.usuarios.repository.usuarioRepository;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("usuarioService")
public class usuarioService {

    @Autowired
    private usuarioRepository usuarioRepository;
    private final RestTemplate restTemplate;

    public usuarioService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Transactional
    public List<DtoUsuario> findAll() throws Exception {
        var resultados = usuarioRepository.findAll();
        try {
            return resultados.stream()
                    .map(resultado -> new DtoUsuario(resultado.getId(), resultado.getNombre(), resultado.getApellido(),
                            resultado.getCelular(), resultado.getEmail()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public DtoUsuario findById(Long id) {
        Optional<usuario> res = usuarioRepository.findById(id);
        if (res.isPresent()) {
            usuario resultado = res.get();
            return new DtoUsuario(resultado.getId(), resultado.getNombre(), resultado.getApellido(),
                    resultado.getCelular(), resultado.getEmail());
        } else {
            return null;
        }
    }

    @Transactional
    public DtoUsuario save(usuario usuario) {
        usuario resultado = usuarioRepository.save(usuario);
        return new DtoUsuario(resultado.getId(), resultado.getNombre(), resultado.getApellido(), resultado.getCelular(),
                resultado.getEmail());
    }


    @Transactional
    public boolean deleteById(Long id) {
        Optional<usuario> admin = usuarioRepository.findById(id);
        if (admin.isPresent()) {
            usuarioRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public String monopatinesCercanos(int x, int y, int distancia) throws Exception {

        String url = "http://localhost:8083/monopatin/x/" + x + "/y/" + y + "/maxDistance/" + distancia;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            throw new Exception("No anduvo");
        }
    }

    // @Transactional
    // public DtoUsuario update(Long id, usuario usuarioActualizado) {
    // Optional<usuario> usuarioExistente = usuarioRepository.findById(id);

    // if (usuarioExistente.isPresent()) {
    // usuario usuario = usuarioExistente.get();
    // usuario.setNombre(usuarioActualizado.getNombre());
    // usuario.setApellido(usuarioActualizado.getApellido());
    // usuario.setCelular(usuarioActualizado.getCelular());
    // usuario.setEmail(usuarioActualizado.getEmail());
    // return usuarioRepository.save(usuario);
    // } else {
    // // Manejar el caso en el que el usuario no existe.
    // return null;
    // }
    // }
}
