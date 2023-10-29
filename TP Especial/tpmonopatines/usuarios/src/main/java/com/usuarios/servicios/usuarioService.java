package com.usuarios.servicios;

import com.usuarios.model.usuario;
import com.usuarios.repository.usuarioRepository;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("usuarioService")
public class usuarioService {

    @Autowired
    private usuarioRepository usuarioRepository;

    @Transactional
    public Optional<usuario> obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    @Transactional
    public usuario save(usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Transactional
    public List<usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Transactional
    public usuario update(Long id, usuario usuarioActualizado) {
        Optional<usuario> usuarioExistente = usuarioRepository.findById(id);

        if (usuarioExistente.isPresent()) {
            usuario usuario = usuarioExistente.get();
            usuario.setNombre(usuarioActualizado.getNombre());
            usuario.setApellido(usuarioActualizado.getApellido());
            usuario.setCelular(usuarioActualizado.getCelular());
            usuario.setEmail(usuarioActualizado.getEmail());
            return usuarioRepository.save(usuario);
        } else {
            // Manejar el caso en el que el usuario no existe.
            return null;
        }
    }

    @Transactional
    public void deleteById(Long id) {
    }

    // Puedes agregar más métodos para realizar operaciones de negocio relacionadas
    // con los usuarios.
}
