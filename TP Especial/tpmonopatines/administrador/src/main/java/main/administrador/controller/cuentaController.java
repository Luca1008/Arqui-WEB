package main.administrador.controller;

import org.springframework.web.bind.annotation.*;
import main.administrador.servicios.cuentaServicio;


@RestController
@RequestMapping("/cuenteAd")
public class cuentaController {
    private final cuentaServicio cuentaService;

    public cuentaController(cuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    @PostMapping
    public cuenta crearcuenta(@RequestBody cuenta cuenta) {
        return cuentaService.save(cuenta);
    }

    @GetMapping("/{cuentaId}")
    public cuenta obtenercuentaPorId(@PathVariable Long cuentaId) {
        return cuentaService.obtenercuentaPorId(cuentaId);
    }
}