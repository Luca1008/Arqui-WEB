package main.administrador.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.*;
import main.administrador.model.administrador;
import main.administrador.servicios.administradorService;


@RestController
@RequestMapping("/administrador")
public class administradorController {
    private final administradorService administradorService;

    public administradorController(administradorService administradorService) {
        this.administradorService = administradorService;
    }

    @PostMapping
    public administrador crearadministrador(@RequestBody administrador administrador) {
        return administradorService.save(administrador);
    }

    @GetMapping("/{administradorId}")
    public Optional<administrador> obteneradministradorPorId(@PathVariable Long administradorId) {
        return administradorService.obteneradministradorPorId(administradorId);
    }
}