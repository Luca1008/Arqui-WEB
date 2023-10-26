package com.paradas.controller;

import org.springframework.web.bind.annotation.*;

import com.paradas.model.viaje;
import com.paradas.repository.viajeRepository;
import java.util.List;

@RestController
@RequestMapping("/viaje")
public class viajeController {
    private final viajeService viajeServicio;

    public viajeController(viajeService viajeServicio) {
        this.viajeServicio = viajeServicio;
    }

    // Endpoint para crear un viaje
    @PostMapping("/")
    public viaje crearViaje(@RequestBody viaje viaje) {
        return viajeServicio.save(viaje);
    }

    // Endpoint para obtener todos los viajes
    @GetMapping("/")
    public List<viaje> obtenerviajes() {
        return viajeServicio.findAll();
    }

}
