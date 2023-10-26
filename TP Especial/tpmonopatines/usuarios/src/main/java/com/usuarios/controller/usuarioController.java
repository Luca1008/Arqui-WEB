package com.usuarios.controller;

import org.springframework.web.bind.annotation.*;

import com.usuarios.model.usuario;
import com.usuarios.repository.usuarioRepository;
import com.usuarios.servicios.usuarioService;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class usuarioController {
    private final usuarioService usuarioServicio;

    public usuarioController(usuarioService usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    // Endpoint para crear un usuario
    @PostMapping("/")
    public usuario crearUsuario(@RequestBody usuario usuario) {
        return usuarioService.save(usuario);
    }

    // Endpoint para obtener todos los usuarios
    @GetMapping("/")
    public List<usuario> obtenerUsuarios() {
        return usuarioService.findAll();
    }

    // Puedes agregar más endpoints según las necesidades de tu aplicación.
}
