package main.administrador.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import main.administrador.model.administrador;
import main.administrador.servicios.administradorService;

@RestController
@RequestMapping("administrador")
public class administradorController {
    @Qualifier("administradorService")
    @Autowired

    private final administradorService administradorService;

    public administradorController(@Qualifier("administradorService") administradorService administradorService) {
        this.administradorService = administradorService;
    }

    @GetMapping("/")
    public List<administrador> findAll() {
        return administradorService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<administrador> findById(@PathVariable Long id) {
        return administradorService.findById(id);
    }

    @PostMapping("/")
    public administrador create(@RequestBody administrador administrador) {
        return administradorService.save(administrador);
    }

    @PutMapping("/{id}")
    public administrador update(@PathVariable Long id, @RequestBody administrador administrador) {
        return administradorService.update(id, administrador);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        administradorService.deleteById(id);
    }
}