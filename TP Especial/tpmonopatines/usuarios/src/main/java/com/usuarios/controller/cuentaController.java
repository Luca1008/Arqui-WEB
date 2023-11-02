package com.usuarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.usuarios.Dtos.DtoCuenta;
import com.usuarios.model.cuenta;
import com.usuarios.servicios.cuentaService;


@RestController
@RequestMapping("cuentas")
public class cuentaController {
    @Qualifier("cuentaService")

    @Autowired
    private final cuentaService cuentaService;
    

    public cuentaController(@Qualifier("cuentaService") cuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    @GetMapping("/{cuentaId}")
    public ResponseEntity<DtoCuenta> findById(@PathVariable Long cuentaId) throws Exception {
        DtoCuenta resultado = cuentaService.findById(cuentaId);
        if (resultado != null) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/")
    public ResponseEntity<List<DtoCuenta>> findAll() throws Exception {
        List<DtoCuenta> resultado = cuentaService.findAll();
        if (!resultado.isEmpty()) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody cuenta cuenta) throws Exception{
        DtoCuenta resultado = cuentaService.save(cuenta);
        if (resultado != null) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.badRequest().body("Hay un error de sintaxis en el body");
        }
    }


    @DeleteMapping("/{cuentaId}")
    public ResponseEntity<String> deleteById(@PathVariable Long cuentaId) throws Exception{
        Boolean resultado = cuentaService.deleteById(cuentaId);
        if (resultado) {
            return ResponseEntity.status(HttpStatus.OK).body("Administrador borrado con exito");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El administrador a borrar no existe");
        }
    }

    @GetMapping("/anular/{cuentaId}")
    public ResponseEntity<String> anularCuenta(@PathVariable Long cuentaId) throws Exception{
        Boolean resultado = cuentaService.anularCuenta(cuentaId);
        if (resultado) {
            return ResponseEntity.status(HttpStatus.OK).body("Cuenta Anulada");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("la cuenta no existe");
        }
    }
}
