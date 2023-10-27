package main.paradas.controller;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import main.paradas.model.monopatin;
import main.paradas.servicios.monopatinService;

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

    @GetMapping("/")
    public List<monopatin> generarReporteKm(boolean tiempoDePausa) {
        return monopatinServicio.generarReporteKm(tiempoDePausa);
    }
    public List<monopatin> buscarMonopatinesConMasDeXViajesEnAnio(int year, int numViajes){
        return monopatinServicio.buscarMonopatinesConMasDeXViajesEnAnio(year,numViajes);
    }

}
