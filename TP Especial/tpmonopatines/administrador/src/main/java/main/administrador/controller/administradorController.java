package main.administrador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import main.administrador.Dtos.DtoAdministrador;
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
    public ResponseEntity<List<DtoAdministrador>> findAll() throws Exception {
        List<DtoAdministrador> resultado = administradorService.findAll();
        if (!resultado.isEmpty()) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DtoAdministrador> findById(@PathVariable Long id) {
        DtoAdministrador resultado = administradorService.findById(id);
        if (resultado != null) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody administrador administrador) {
        DtoAdministrador resultado = administradorService.save(administrador);
        if (resultado != null) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.badRequest().body("Hay un error de sintaxis en el body");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        Boolean resultado = administradorService.deleteById(id);
        if (resultado) {
            return ResponseEntity.status(HttpStatus.OK).body("Administrador borrado con exito");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El administrador a borrar no existe");
        }
    }

    @GetMapping("/cuenta/anular/{id}")
    public ResponseEntity<String> anular(@PathVariable Long id) throws Exception {
        String resultado = administradorService.anularCuenta(id);
        if (!resultado.isEmpty()) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body("No hay cuenta para anular");
        }
    }

    @GetMapping("/buscar/year/{year}/viajes/{numViajes}")
    public ResponseEntity<String> monopatinesConXviajesEnXaño(@PathVariable int numViajes, @PathVariable int year) throws Exception {
        String resultado = administradorService.monopatinesConXviajesEnXaño(year,numViajes);
        if (!resultado.isEmpty()) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body("No hay monopatines con al menos " + numViajes + "viajes en " + year);
        }
    }
    
    @GetMapping("/CalcularTotal/year/{year}/mesInicio/{mesInicio}/mesFin/{mesFin}")
    public ResponseEntity<String> facturadoEntreMesesdeXaño(@PathVariable int year, @PathVariable int mesInicio, @PathVariable int mesFin) throws Exception {
        String resultado = administradorService.facturadoEntreMesesdeXaño(year, mesInicio, mesFin);
        if (!resultado.isEmpty()) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No hay viajes entre esos meses");
        }
    }
    
    @GetMapping("/monopatinesEnOperacionOEnMantenimiento")
    public ResponseEntity<String> monopatinesEnFuncionamientoVsMantenimiento() throws Exception {
        String resultado = administradorService.monopatinesEnFuncionamientoVsMantenimiento();
        if (!resultado.isEmpty()) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No hay monopatines");
        }
    }

    // @PutMapping("/tarifa/year/{year}/mes/{mes}/day/{day}/tarifa/{tarifa}")
    // public void actualizarTarifaEnXFecha(@PathVariable int year, @PathVariable int mes, @PathVariable int day, @PathVariable int tarifa) throws Exception {
    //     try {
    //         administradorService.actualizarTarifasEnXfecha(year,mes,day,tarifa);
    //     } catch (Exception e) {
    //         throw new Exception("No anduvo");
    //     }
    // }
}