package com.usuarios.controller;

import org.springframework.web.bind.annotation.*;

import com.usuarios.model.usuario;
import com.usuarios.repository.usuarioRepository;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class usuarioController {
    private final usuarioRepository usuarioRepository;

    public usuarioController(usuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Endpoint para crear un usuario
    @PostMapping("/")
    public usuario crearUsuario(@RequestBody usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Endpoint para obtener todos los usuarios
    @GetMapping("/")
    public List<usuario> obtenerUsuarios() {
        return usuarioRepository.findAll();
    }

    // Puedes agregar más endpoints según las necesidades de tu aplicación.
}
