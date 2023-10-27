package main.paradas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/")
    public parada save(@RequestBody parada parada) {
        return paradaService.save(parada);
    }

    @GetMapping("/")
    public List<parada> obtenerParadas() {
        return paradaService.findAll();
    }
    
    @GetMapping("/{id}")
    public Optional<parada> obtenerParadaPorId(@PathVariable Long id) {
        return paradaService.findById(id);
    }

    @PutMapping("/{id}")
    public parada actualizarParada(@PathVariable Long id, @RequestBody parada parada) {
        return paradaService.save(parada);
    }
    
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        paradaService.deleteById(id);
    }
}

