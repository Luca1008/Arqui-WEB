package com.usuarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.usuarios.Dtos.DtoCuenta;
import com.usuarios.model.cuenta;
import com.usuarios.model.usuario;
import com.usuarios.servicios.cuentaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("cuentas")
public class cuentaController {
    @Qualifier("cuentaService")

    @Autowired
    private final cuentaService cuentaService;

    public cuentaController(@Qualifier("cuentaService") cuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    @Operation(summary = "encontrar cuenta por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "cuenta encontrado con exito", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = cuenta.class))
            }),
            @ApiResponse(responseCode = "500", description = "Id invalido", content = @Content),
            @ApiResponse(responseCode = "400", description = "Error in Response Body", content = @Content)
    })
    @GetMapping("/{cuentaId}")
    public ResponseEntity<DtoCuenta> findById(@PathVariable Long cuentaId) throws Exception {
        DtoCuenta resultado = cuentaService.findById(cuentaId);
        if (resultado != null) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<DtoCuenta>> findAll() throws Exception {
        List<DtoCuenta> resultado = cuentaService.findAll();
        if (!resultado.isEmpty()) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Registrar cuenta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "cuenta creada", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = cuenta.class))
            }),
            @ApiResponse(responseCode = "500", description = "error server", content = @Content),
            @ApiResponse(responseCode = "400", description = "Error in Response Body", content = @Content)
    })
    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody cuenta cuenta) throws Exception {
        DtoCuenta resultado = cuentaService.save(cuenta);
        if (resultado != null) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.badRequest().body("Hay un error de sintaxis en el body");
        }
    }

    @Operation(summary = "Eliminar cuenta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "cuenta eliminada", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = cuenta.class))
            }),
            @ApiResponse(responseCode = "500", description = "error server", content = @Content),
            @ApiResponse(responseCode = "400", description = "Error in Response Body", content = @Content)
    })
    @DeleteMapping("/{cuentaId}")
    public ResponseEntity<String> deleteById(@PathVariable Long cuentaId) throws Exception {
        Boolean resultado = cuentaService.deleteById(cuentaId);
        if (resultado) {
            return ResponseEntity.status(HttpStatus.OK).body("Administrador borrado con exito");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El administrador a borrar no existe");
        }
    }

    @Operation(summary = "Anular cuenta ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cuenta anulada", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = cuenta.class))
            }),
            @ApiResponse(responseCode = "500", description = "error server", content = @Content),
            @ApiResponse(responseCode = "400", description = "Error in Response Body", content = @Content)
    })
    @GetMapping("/anular/{cuentaId}")
    public ResponseEntity<String> anularCuenta(@PathVariable Long cuentaId) throws Exception {
        Boolean resultado = cuentaService.anularCuenta(cuentaId);
        if (resultado) {
            return ResponseEntity.status(HttpStatus.OK).body("Cuenta Anulada");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("la cuenta no existe");
        }
    }
}
