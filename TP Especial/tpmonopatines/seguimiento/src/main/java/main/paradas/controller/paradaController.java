package main.paradas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import main.paradas.dtos.DtoParada;
import main.paradas.model.parada;
import main.paradas.servicios.paradaService;


@RestController
@RequestMapping("/parada")
public class paradaController {
    @Qualifier("paradaService")

    @Autowired
    private paradaService paradaService;

    public paradaController(paradaService paradaService) {
        this.paradaService = paradaService;
    }

    @GetMapping("/")
    public ResponseEntity<List<DtoParada>> findAll() throws Exception {
        List<DtoParada> resultado = paradaService.findAll();
        if (!resultado.isEmpty()) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DtoParada> findById(@PathVariable Long id) {
        DtoParada resultado = paradaService.findById(id);
        if (resultado != null) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody parada parada) {     
        DtoParada resultado = paradaService.save(parada);
        if (resultado != null) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.badRequest().body("Hay un error de sintaxis en el body");
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        
        Boolean resultado = paradaService.deleteById(id);
        if (resultado) {
            return ResponseEntity.status(HttpStatus.OK).body("Parada borrada con exito");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La parada a borrar no existe");
        }
    }
}

