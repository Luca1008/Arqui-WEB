package main.administrador.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<List<administrador>> findAll() {
        List<administrador> resultado = administradorService.findAll();
        if (!resultado.isEmpty()) {
            return ResponseEntity.ok(resultado);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<administrador>> findById(@PathVariable Long id) {
        Optional<administrador> resultado = administradorService.findById(id);
        if (!resultado.isEmpty()) {
            return ResponseEntity.ok(resultado);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody administrador administrador) {
        administrador resultado = administradorService.save(administrador);
        if (resultado != null) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.badRequest().body("Hay un error de sintaxis en el body");
        }
    }

    @PutMapping("/{id}")
    public administrador update(@PathVariable Long id, @RequestBody administrador administrador) {
        return administradorService.update(id, administrador);
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

    @GetMapping("/cuenta/{id}/anular")
    public ResponseEntity<String> anular(@PathVariable Long id) throws Exception {
        String resultado = administradorService.anularCuenta(id);
        if (resultado.equals("true")) {
            return ResponseEntity.status(HttpStatus.OK).body("Cuenta anulada con exito");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La cuenta a anular no existe");
        }
    }
}