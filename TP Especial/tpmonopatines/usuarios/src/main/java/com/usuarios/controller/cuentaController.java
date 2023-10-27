package com.usuarios.controller;

import java.util.List;

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

    @GetMapping("/{cuentaId}")
    public cuenta obtenerCuentaPorId(@PathVariable Long cuentaId) throws Exception {
        return cuentaService.obtenerCuentaPorId(cuentaId);
    }
    @GetMapping
    public List<cuenta> obtenerTodosLoscuentas() throws Exception {
        return cuentaService.obtenerTodosLoscuentas();
    }
    
    @PostMapping
    public cuenta crearCuenta(@RequestBody cuenta cuenta) throws Exception{
        return cuentaService.save(cuenta);
    }

    @PutMapping("/{cuentaId}")
    public cuenta modificarCuenta(@PathVariable Long cuentaId, @RequestBody cuenta cuenta) throws Exception{
        return cuentaService.modificarCuentaPorId(cuentaId);
    }

    @DeleteMapping("/{cuentaId}")
    public void eliminarCuentaPorId(@PathVariable Long cuentaId) throws Exception{
        cuentaService.eliminarCuentaPorId(cuentaId);
    }

    @PutMapping("/{cuentaId}") //chequear si es lo mismo que esta arriba
    public void anularCuenta(@PathVariable Long cuentaId) throws Exception{
        cuentaService.anularCuenta(cuentaId);
    }
    

}
