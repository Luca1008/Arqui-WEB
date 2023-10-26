package main.administrador.controller;

import java.util.List;
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

    @GetMapping
    public List<administrador> findAll() {
        return administradorService.findAll();
    }
    
    @GetMapping("/{id}")
    public Optional<administrador> findById(@PathVariable Long id) {
        return administradorService.findById(id);
    }

    @PostMapping
    public administrador create(@RequestBody administrador administrador) {
        return administradorService.save(administrador);
    }

    @PutMapping
    public administrador update(@PathVariable Long id, @RequestBody administrador administrador) {
        return administradorService.update(id, administrador);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        administradorService.deleteById(id);
    }
}