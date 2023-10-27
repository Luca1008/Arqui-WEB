package main.paradas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import main.paradas.model.viaje;
import main.paradas.servicios.viajeService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("viaje")
public class viajeController {
    @Qualifier("viajeService")

    @Autowired
    private viajeService viajeService;

    public viajeController(viajeService viajeService) {
        this.viajeService = viajeService;
    }

    @PostMapping("/")
    public viaje crearViaje(@RequestBody viaje viaje) {
        return viajeService.save(viaje);
    }

    @GetMapping("/")
    public List<viaje> obtenerviajes() {
        return viajeService.findAll();
    }

    @GetMapping("/CalcularTotal/{year}/{mesInicio}/{mesFin}")
    public int calcularTotalFacturadoEnRangoDeMeses(@PathVariable int year, @PathVariable int mesInicio, @PathVariable int mesFin) throws Exception{
        return viajeService.calcularTotalFacturadoEnRangoDeMeses(year,mesInicio,mesFin);
    }
    
    //para el punto 3 f 
    // public void ajustarPrecio(LocalDate fechaActual, int nuevoPrecio){
    //     viajeService.ajustarPrecio(fechaActual, nuevoPrecio);
    // }

}
