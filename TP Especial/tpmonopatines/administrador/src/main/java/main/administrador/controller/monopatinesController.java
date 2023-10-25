package main.administrador.controller;

import org.springframework.web.bind.annotation.*;
import main.administrador.servicios.monopatinServicio;


@RestController
@RequestMapping("/monopatinAd")
public class monopatinController {
    private final monopatinServicio monopatinService;

    public monopatinController(monopatinService monopatinService) {
        this.monopatinService = monopatinService;
    }

    @PostMapping
    public monopatin crearmonopatin(@RequestBody monopatin monopatin) {
        return monopatinService.save(monopatin);
    }

    @GetMapping("/{monopatinId}")
    public monopatin obtenermonopatinPorId(@PathVariable Long monopatinId) {
        return monopatinService.obtenermonopatinPorId(monopatinId);
    }
}