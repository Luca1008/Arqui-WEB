package com.usuarios.Dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRequestDTO {

    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private Set<Long> cuentas;
    private Set<String> authorities;

    public UserRequestDTO(String nombre, String apellido, String email, String password, Set<Long> cuentas,
            Set<String> authorities) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.cuentas = cuentas;
        this.authorities = authorities;
    }

}
