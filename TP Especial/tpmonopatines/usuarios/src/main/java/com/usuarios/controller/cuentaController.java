package com.usuarios.controller;

import org.springframework.web.bind.annotation.*;
import com.usuarios.model.cuenta;
import com.usuarios.servicios.cuentaService;


@RestController
@RequestMapping("/cuentas")
public class cuentaController {
    private final cuentaService cuentaService;

    public cuentaController(cuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    @PostMapping
    public cuenta crearCuenta(@RequestBody cuenta cuenta) {
        return cuentaService.save(cuenta);
    }

    @GetMapping("/{cuentaId}")
    public cuenta obtenerCuentaPorId(@PathVariable Long cuentaId) {
        return cuentaService.obtenerCuentaPorId(cuentaId);
    }
}
