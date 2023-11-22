package main.mantenimiento.controller;

import java.util.List;
import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import main.mantenimiento.Dtos.DtoMantenimiento;
import main.mantenimiento.model.mantenimiento;
import main.mantenimiento.security.AuthorityConstants;
import main.mantenimiento.servicios.mantenimientoService;

@RestController
@RequestMapping("mantenimiento")
public class mantenimientoController {
    @Qualifier("mantenimientoService")

    @Autowired
    private final mantenimientoService mantenimientoService;

    public mantenimientoController(mantenimientoService mantenimientoService) {
        this.mantenimientoService = mantenimientoService;
    }

    @GetMapping("/")
    @PreAuthorize("hasAnyAuthority(\"" + AuthorityConstants.MANTENIMIENTO + "\" )")
    public ResponseEntity<List<DtoMantenimiento>> findAll() throws Exception {
        List<DtoMantenimiento> resultado = mantenimientoService.findAll();
        if (!resultado.isEmpty()) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority(\"" + AuthorityConstants.USER + "\" )")
    public ResponseEntity<DtoMantenimiento> findById(@PathVariable String id) {
        DtoMantenimiento resultado = mantenimientoService.findById(id);
        if (resultado != null) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    @PreAuthorize("hasAnyAuthority(\"" + AuthorityConstants.ADMIN + "\" )")
    public ResponseEntity<?> save(@RequestBody mantenimiento mantenimiento) {
        DtoMantenimiento resultado = mantenimientoService.save(mantenimiento);
        if (resultado != null) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.badRequest().body("Hay un error de sintaxis en el body");
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority(\"" + AuthorityConstants.ADMIN + "\" )")
    public ResponseEntity<String> delete(@PathVariable String id) {
        Boolean resultado = mantenimientoService.deleteById(id);
        if (resultado) {
            return ResponseEntity.status(HttpStatus.OK).body("Administrador borrado con exito");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El administrador a borrar no existe");
        }
    }

    @GetMapping("/monopatinesKM/")
    @PreAuthorize("hasAnyAuthority(\"" + AuthorityConstants.ADMIN + "\" )")
    public ResponseEntity<String> reporteMonopatinesKm() throws Exception {
        String resultado = mantenimientoService.reporteDeMonopatinesKM();
        if (!resultado.isEmpty()) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No hay reporte");
        }
    }

    @GetMapping("/monopatinesKM/pausa")
    @PreAuthorize("hasAnyAuthority(\"" + AuthorityConstants.ADMIN + "\" )")
    public ResponseEntity<String> reporteMonopatinesKmconPausa() throws Exception {
        String resultado = mantenimientoService.reporteDeMonopatinesKMconPausa();
        if (!resultado.isEmpty()) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No hay reporte");
        }
    }

}
