package main.paradas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.http.HttpStatus;

import main.paradas.security.AuthorityConstants;
import main.paradas.dtos.DtoViaje;
import main.paradas.model.viaje;
import main.paradas.servicios.viajeService;

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
    @PreAuthorize("hasAnyAuthority(\"" + AuthorityConstants.MANTENIMIENTO + "\" )")
    public ResponseEntity<?> save(@RequestBody viaje viaje) {
        DtoViaje resultado = viajeService.save(viaje);
        if (resultado != null) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.badRequest().body("Hay un error de sintaxis en el body");
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<DtoViaje>> findAll() throws Exception {
        List<DtoViaje> resultado = viajeService.findAll();
        if (!resultado.isEmpty()) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DtoViaje> findById(@PathVariable Long id) {
        DtoViaje resultado = viajeService.findById(id);
        if (resultado != null) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        Boolean resultado = viajeService.deleteById(id);
        if (resultado) {
            return ResponseEntity.status(HttpStatus.OK).body("viaje borrado con exito");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El viaje a borrar no existe");
        }
    }

    @GetMapping("/CalcularTotal/year/{year}/mesInicio/{mesInicio}/mesFin/{mesFin}")
    public ResponseEntity<?> calcularTotalFacturadoEnRangoDeMeses(@PathVariable int year, @PathVariable int mesInicio,
            @PathVariable int mesFin) throws Exception {
        int resultado = viajeService.calcularTotalFacturadoEnRangoDeMeses(year, mesInicio, mesFin);
        if (resultado > 0) {
            return ResponseEntity.ok("Total facturado: " + resultado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El total es cero");
        }
    }

}
