package com.paradas.controller;

import org.springframework.web.bind.annotation.*;

import com.paradas.model.monopatin;
import com.paradas.repository.monopatinRepository;
import java.util.List;

@RestController
@RequestMapping("/monopatin")
public class monopatinController {
    private final monopatinService monopatinServicio;

    public monopatinController(monopatinService monopatinServicio) {
        this.monopatinServicio = monopatinServicio;
    }

    // Endpoint para crear un monopatin
    @PostMapping("/")
    public monopatin crearMonopatin(@RequestBody monopatin monopatin) {
        return monopatinServicio.save(monopatin);
    }

    // Endpoint para obtener todos los monopatines
    @GetMapping("/")
    public List<monopatin> obtenerMonopatines() {
        return monopatinServicio.findAll();
    }

}
