package com.usuarios.servicios;

import com.usuarios.model.usuario;
import com.usuarios.repository.usuarioRepository;

import java.util.List;
import java.util.Optional;

public class usuarioService {
    private final usuarioRepository usuarioRepository;

    public usuarioService(usuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public usuario crearUsuario(usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<usuario> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<usuario> obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    // Puedes agregar más métodos para realizar operaciones de negocio relacionadas con los usuarios.
}
