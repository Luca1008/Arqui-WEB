package main.administrador.controller;

import org.springframework.web.bind.annotation.*;
import main.administrador.model.administrador;
import main.administrador.servicios.administradorServicio;


@RestController
@RequestMapping("/administrador")
public class administradorController {
    private final administradorServicio administradorService;

    public administradorController(administradorService administradorService) {
        this.administradorService = administradorService;
    }

    @PostMapping
    public administrador crearadministrador(@RequestBody administrador administrador) {
        return administradorService.save(administrador);
    }

    @GetMapping("/{administradorId}")
    public administrador obteneradministradorPorId(@PathVariable Long administradorId) {
        return administradorService.obteneradministradorPorId(administradorId);
    }
}