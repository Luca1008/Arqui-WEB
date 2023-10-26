package main.mantenimiento.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import main.mantenimiento.model.mantenimiento;
import main.mantenimiento.servicios.mantenimientoService;


@RestController
@RequestMapping("/mantenimiento")
public class mantenimientoController {
    private final mantenimientoService mantenimientoService;

    public mantenimientoController(mantenimientoService mantenimientoService) {
        this.mantenimientoService = mantenimientoService;
    }
    
    @GetMapping
    public List<mantenimiento> findAll() {
        return mantenimientoService.findAll();
    }
    
    @GetMapping("/{id}")
    public Optional<mantenimiento> findById(@PathVariable Long id) {
        return mantenimientoService.findById(id);
    }
    @PostMapping
    public mantenimiento create(@RequestBody mantenimiento mantenimiento) {
        return mantenimientoService.save(mantenimiento);
    }
    
    
    @PutMapping("/{id}")
    public mantenimiento update(@PathVariable Long id, @RequestBody mantenimiento mantenimiento) {
        return mantenimientoService.update(id, mantenimiento);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        mantenimientoService.deleteById(id);
    }

}
