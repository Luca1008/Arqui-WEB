package com.usuarios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.usuarios.Dtos.AuthRequestDTO;
import com.usuarios.Dtos.DtoUsuario;
import com.usuarios.Dtos.UserRequestDTO;
import com.usuarios.model.usuario;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import com.usuarios.security.jwt.JWTFilter;
import com.usuarios.security.jwt.TokenProvider;
import com.usuarios.servicios.usuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("usuarios")
@RequiredArgsConstructor
public class usuarioController {
    @Qualifier("usuarioService")
    private final usuarioService usuarioService;
    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    /**
     * Valida el token y devuelve un JSON con nombre de usuario y sus autoridades.
     */
    @GetMapping("/validate")
    public ResponseEntity<ValidateTokenDTO> validateGet() {
        final var user = SecurityContextHolder.getContext().getAuthentication();
        final var authorities = user.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
        return ResponseEntity.ok(
                ValidateTokenDTO.builder()
                        .username(user.getName())
                        .authorities(authorities)
                        .isAuthenticated(true)
                        .build());
    }

    @Data
    @Builder
    public static class ValidateTokenDTO {
        private boolean isAuthenticated;
        private String username;
        private List<String> authorities;
    }

    // INICIAR SESION
    @PostMapping("/authenticate")
    public ResponseEntity<JWTToken> authenticate(@Valid @RequestBody AuthRequestDTO request) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                request.getEmail(), request.getContrasenia());

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final var jwt = tokenProvider.createToken(authentication);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JWTFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);
        return new ResponseEntity<>(new JWTToken(jwt), httpHeaders, HttpStatus.OK);
    }

    static class JWTToken {
        private String idToken;

        JWTToken(String idToken) {
            this.idToken = idToken;
        }

        @JsonProperty("id_token")
        String getIdToken() {
            return idToken;
        }

        void setIdToken(String idToken) {
            this.idToken = idToken;
        }
    }

    @Operation(summary = "mostrar todos los usuarios")
    @GetMapping("/")
    public ResponseEntity<List<DtoUsuario>> findAll() throws Exception {
        List<DtoUsuario> resultado = usuarioService.findAll();
        if (!resultado.isEmpty()) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "encontrar usuario por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "usuario encontrado con exito",
            content = {
                    @Content(mediaType = "application/json",
                    schema = @Schema(implementation = usuario.class))
                    }),
            @ApiResponse(responseCode = "500",description = "Id invalido", content = @Content),
            @ApiResponse(responseCode = "400",description = "Error in Response Body",content = @Content)
                })

    @GetMapping("/{id}")
    public ResponseEntity<DtoUsuario> findById(@PathVariable Long id) {
        DtoUsuario resultado = usuarioService.findById(id);
        if (resultado != null) {
            return ResponseEntity.ok(resultado);
        } else { 
            return ResponseEntity.notFound().build();
        }
    }


@Operation(summary = "Registrar usuario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "usuario registrado",
            content = {
                    @Content(mediaType = "application/json",
                    schema = @Schema(implementation = usuario.class))
                    }),
            @ApiResponse(responseCode = "500",description = "error server", content = @Content),
            @ApiResponse(responseCode = "400",description = "Error in Response Body",content = @Content)
                })
    @PostMapping("/register")
    public ResponseEntity<?> save(@RequestBody UserRequestDTO usuario) {
        var resultado = usuarioService.createUser(usuario);
        if (resultado != null) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.badRequest().body("Hay un error de sintaxis en el body");
        }
    }

@Operation(summary = "Eliminar usuario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "usuario eliminado",
            content = {
                    @Content(mediaType = "application/json",
                    schema = @Schema(implementation = usuario.class))
                    }),
            @ApiResponse(responseCode = "500",description = "error server", content = @Content),
            @ApiResponse(responseCode = "400",description = "Error in Response Body",content = @Content)
                })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        Boolean resultado = usuarioService.deleteById(id);
        if (resultado) {
            return ResponseEntity.status(HttpStatus.OK).body("usuario borrado con exito");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El usuario a borrar no existe");
        }
    }

@Operation(summary = "Obtener monopatines por distancia")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Monopatines cercanos",
            content = {
                    @Content(mediaType = "application/json",
                    schema = @Schema(implementation = usuario.class))
                    }),
            @ApiResponse(responseCode = "500",description = "error server", content = @Content),
            @ApiResponse(responseCode = "400",description = "Error in Response Body",content = @Content)
                })
    @GetMapping("/monopatin/x/{x}/y/{y}/maxDistance/{maxDistance}")
    public ResponseEntity<String> getUsersByPositionAndMaxDistance(@PathVariable int x, @PathVariable int y,
            @PathVariable int maxDistance) throws Exception {
        String resultado = usuarioService.monopatinesCercanos(x, y, maxDistance);
        if (!resultado.isEmpty()) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No hay monopatines");
        }
    }
}
