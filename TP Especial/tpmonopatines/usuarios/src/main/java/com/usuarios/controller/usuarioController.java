package com.usuarios.controller;

import org.springframework.web.bind.annotation.*;

import com.usuarios.model.usuario;
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
        return usuarioServicio.save(usuario);
    }

    // Endpoint para obtener todos los usuarios
    @GetMapping("/")
    public List<usuario> obtenerUsuarios() throws Exception {
        return usuarioServicio.findAll();
    }

    // Endpoint para actualizar un usuario
    @PutMapping("/{id}/")
    public usuario actualizarUsuario(@PathVariable Long id, @RequestBody usuario usuarioActualizado) throws Exception {
        return usuarioServicio.update(id, usuarioActualizado);
    }

    // Endpoint para eliminar usuario
    @DeleteMapping("/{id}/")
    public void borrarUsuario(@PathVariable Long id){
        usuarioServicio.deleteById(id);
    }
}
