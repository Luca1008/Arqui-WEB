package main.administrador.controller;

import org.springframework.web.bind.annotation.*;
import main.administrador.servicios.paradasServicio;


@RestController
@RequestMapping("/paradasAd")
public class paradasController {
    private final paradasServicio paradasService;

    public paradasController(paradasService paradasService) {
        this.paradasService = paradasService;
    }

    @PostMapping
    public paradas crearparadas(@RequestBody paradas paradas) {
        return paradasService.save(paradas);
    }

    @GetMapping("/{paradasId}")
    public paradas obtenerparadasPorId(@PathVariable Long paradasId) {
        return paradasService.obtenerparadasPorId(paradasId);
    }
}