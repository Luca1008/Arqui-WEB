package com.usuarios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import com.usuarios.model.usuario;
import com.usuarios.servicios.usuarioService;

import java.util.List;

@RestController
@RequestMapping("usuarios")
public class usuarioController {
    @Qualifier("usuarioService")
    private final usuarioService usuarioService;

    @Autowired
    public usuarioController(@Qualifier("usuarioService") usuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/")
    public usuario crearUsuario(@RequestBody usuario usuario) {
        return usuarioService.save(usuario);
    }

    @GetMapping("/")
    public List<usuario> obtenerUsuarios() throws Exception {
        return usuarioService.findAll();
    }

    @PutMapping("/{id}/")
    public usuario actualizarUsuario(@PathVariable Long id, @RequestBody usuario usuarioActualizado) throws Exception {
        return usuarioService.update(id, usuarioActualizado);
    }

    @DeleteMapping("/{id}/")
    public void borrarUsuario(@PathVariable Long id) {
        usuarioService.deleteById(id);
    }
}
