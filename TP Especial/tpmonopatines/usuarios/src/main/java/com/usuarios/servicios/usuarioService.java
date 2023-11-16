package com.usuarios.servicios;

import com.usuarios.Dtos.DtoUsuario;
import com.usuarios.Dtos.UserRequestDTO;
import com.usuarios.Dtos.UserResponseDTO;
import com.usuarios.model.usuario;
import com.usuarios.repository.*;
import com.usuarios.servicios.exception.user.EnumUserException;
import com.usuarios.servicios.exception.user.UserException;
import com.usuarios.servicios.exception.user.NotFoundException;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("usuarioService")
@RequiredArgsConstructor
public class usuarioService {

    @Autowired
    private usuarioRepository usuarioRepository;
    private final RestTemplate restTemplate;
    private final cuentaRepository cuentaRepository;
    private final autoridadRepository autoridadRepository;
    private final PasswordEncoder passwordEncoder;

    public UserResponseDTO createUser(UserRequestDTO request) {
        if (this.usuarioRepository.existsUsuariosByEmailIgnoreCase(request.getEmail()))
            throw new UserException(EnumUserException.already_exist,
                    String.format("Ya existe un usuario con email %s", request.getEmail()));
        final var accounts = this.cuentaRepository.findAllById(request.getCuentas());
        if (accounts.isEmpty())
            throw new UserException(EnumUserException.invalid_account,
                    String.format("No se encontro ninguna cuenta con id %s", request.getCuentas().toString()));
        final var authorities = request.getAuthorities()
                .stream()
                .map(string -> this.autoridadRepository.findById(string)
                        .orElseThrow(() -> new NotFoundException("autoridad", string)))
                .toList();
        if (authorities.isEmpty())
            throw new UserException(EnumUserException.invalid_authorities,
                    String.format("No se encontro ninguna autoridad con id %s", request.getAuthorities().toString()));
        final var user = new usuario(request);
        user.setCuentas(accounts);
        user.setAutoridades(authorities);
        final var encryptedPassword = passwordEncoder.encode(request.getPassword());
        user.setContrasenia(encryptedPassword);
        final var createdUser = this.usuarioRepository.save(user);
        return new UserResponseDTO(createdUser);
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

}
