package main.paradas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import main.paradas.dtos.DtoMonopatin;
import main.paradas.dtos.DtoMonopatinDistancia;
import main.paradas.dtos.DtoMonopatinEnMatenimiento;
import main.paradas.dtos.DtoMonopatinKm;
import main.paradas.dtos.DtoMonopatinKmPausa;
import main.paradas.model.monopatin;
import main.paradas.servicios.monopatinService;

import java.util.List;

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
    public ResponseEntity<List<DtoMonopatin>> findAll() throws Exception {
        List<DtoMonopatin> resultado = monopatinServicio.findAll();
        if (!resultado.isEmpty()) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DtoMonopatin> findById(@PathVariable Long id) {
        DtoMonopatin resultado = monopatinServicio.findById(id);
        if (resultado != null) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody monopatin monopatin) {
        DtoMonopatin resultado = monopatinServicio.save(monopatin);
        if (resultado != null) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.badRequest().body("Hay un error de sintaxis en el body");
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        Boolean resultado = monopatinServicio.deleteById(id);
        if (resultado) {
            return ResponseEntity.status(HttpStatus.OK).body("Monopatin borrado con exito");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El monopatin a borrar no existe");
        }
    }

    @GetMapping("/reporteKM")
    public ResponseEntity<?> generarReporteKm() throws Exception {
        List<DtoMonopatinKm> resultado = monopatinServicio.generarReporteKm();
        if (!resultado.isEmpty()) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No hay reportes");
        }
    }

    @GetMapping("/reporteKM/tiempoPausa")
    public ResponseEntity<?> generarReporteKmConPausa() throws Exception{
        List<DtoMonopatinKmPausa> resultado = monopatinServicio.generarReporteKmConPausa();
        if (!resultado.isEmpty()) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No hay reportes");
        }
    }

    //endpoint que traiga cantidad de monopatines en mantenimiento
    @GetMapping("/monopatinesEnOperacionOEnMantenimiento")
    public ResponseEntity<?> monopatinesEnOperacionOEnMantenimiento() throws Exception{
        List<DtoMonopatinEnMatenimiento> resultado = monopatinServicio.monopatinesEnOperacionOEnMantenimiento();
        if (!resultado.isEmpty()) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No hay monopatines");
        }
    }


    @GetMapping("/buscar/year/{year}/viajes/{numViajes}")
    public ResponseEntity<?> buscarMonopatinesConMasDeXViajesEnAnio(@PathVariable int year,@PathVariable int numViajes) throws Exception{
        List<DtoMonopatin> resultado = monopatinServicio.buscarMonopatinesConMasDeXViajesEnAnio(year, numViajes);
        if (!resultado.isEmpty()) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No hay monopatines con esa cantidad de viajes");
        }
    }


    @GetMapping("/x/{x}/y/{y}/maxDistance/{maxDistance}")
    public ResponseEntity<?> getMonopatinCercanos(@PathVariable int x, @PathVariable int y, @PathVariable int maxDistance) throws Exception {
        List<DtoMonopatinDistancia> resultado = monopatinServicio.getMonopatinCercanos(x, y, maxDistance);
        if (!resultado.isEmpty()) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No hay monopatines cercanos");
        }
    }
}
