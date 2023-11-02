package com.usuarios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.usuarios.Dtos.DtoUsuario;
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

   @GetMapping("/")
    public ResponseEntity<List<DtoUsuario>> findAll() throws Exception {
        List<DtoUsuario> resultado = usuarioService.findAll();
        if (!resultado.isEmpty()) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DtoUsuario> findById(@PathVariable Long id) {
        DtoUsuario resultado = usuarioService.findById(id);
        if (resultado != null) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody usuario usuario) {
        DtoUsuario resultado = usuarioService.save(usuario);
        if (resultado != null) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.badRequest().body("Hay un error de sintaxis en el body");
        }
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        Boolean resultado = usuarioService.deleteById(id);
        if (resultado) {
            return ResponseEntity.status(HttpStatus.OK).body("usuario borrado con exito");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El usuario a borrar no existe");
        }
    }

    @GetMapping("/monopatin/x/{x}/y/{y}/maxDistance/{maxDistance}")
    public ResponseEntity<String> getUsersByPositionAndMaxDistance(@PathVariable int x,@PathVariable int y, @PathVariable int maxDistance) throws Exception{
        String resultado = usuarioService.monopatinesCercanos(x,y,maxDistance);
        if (!resultado.isEmpty()) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No hay monopatines");
        }
    }
}
