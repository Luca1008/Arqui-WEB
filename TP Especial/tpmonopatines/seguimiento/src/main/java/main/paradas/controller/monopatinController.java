package main.paradas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import main.paradas.model.monopatin;
import main.paradas.servicios.monopatinService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("monopatin")
public class monopatinController {
    @Qualifier("monopatinService")

    @Autowired
    private monopatinService monopatinServicio;

    public monopatinController(monopatinService monopatinServicio) {
        this.monopatinServicio = monopatinServicio;
    }

    @GetMapping("/")
    public List<monopatin> findAll() {
        return monopatinServicio.findAll();
    }
    
    @GetMapping("/{id}")
    public Optional<monopatin> findById(@PathVariable Long id) {
        return monopatinServicio.findById(id);
    }
    
    @PostMapping("/")
    public monopatin save(@RequestBody monopatin monopatin) {
        return monopatinServicio.save(monopatin);
    }
   
    @PutMapping("/{id}")
    public monopatin updateMonopatin(@PathVariable Long id, @RequestBody monopatin monopatin) {
        return monopatinServicio.save(monopatin);
    }
    
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        monopatinServicio.deleteById(id);
    }

    
    // @GetMapping("/")
    // public List<monopatin> generarReporteKm(boolean tiempoDePausa) {
    //     return monopatinServicio.generarReporteKm(tiempoDePausa);
    // }

    // public List<monopatin> buscarMonopatinesConMasDeXViajesEnAnio(int year, int numViajes){
    //     return monopatinServicio.buscarMonopatinesConMasDeXViajesEnAnio(year,numViajes);
    // }

    // public int monopatinesEnOperacionOEnMantenimiento(Boolean enMantenimiento){
    //     return monopatinServicio.monopatinesEnOperacionOEnMantenimiento(enMantenimiento);
    // }
    // public List<monopatin> monopatinesCercanos(int latitud, int longuitud, int maxDistancia){
    //     return monopatinServicio.monopatinesCercanos(latitud,longuitud,maxDistancia);
    // }

}
