package com.usuarios.test;

import com.usuarios.Dtos.UserRequestDTO;
import com.usuarios.model.autoridad;
import com.usuarios.model.cuenta;
import com.usuarios.model.usuario;

import java.util.Set;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class usuarioTest {

    @Test
    public void testConstructorWithUserRequestDTO() {
        Set<Long> cuentas = new HashSet<>(Arrays.asList(1L, 2L, 3L));
        Set<String> authorities = new HashSet<>(Arrays.asList("ROLE_USER", "ROLE_ADMIN"));
        UserRequestDTO userRequestDTO = new UserRequestDTO("John", "Doe", "john.doe@example.com", "password123",
                cuentas, authorities);
        usuario user = new usuario(userRequestDTO);

        assertEquals("John", user.getNombre());
        assertEquals("Doe", user.getApellido());
        assertEquals("john.doe@example.com", user.getEmail());
        assertNotNull(user.getCuentas());
        assertNotNull(user.getAutoridades());
    }

    @Test
    public void testSetCuentas() {
        Collection<cuenta> cuentas = Arrays.asList(new cuenta(/* provide necessary parameters */));
        usuario user = new usuario("John", "Doe", 123456789, "john.doe@example.com", "password123");

        user.setCuentas(cuentas);

        assertEquals(cuentas, user.getCuentas());
    }

    @Test
    public void testSetAutoridades() {
        Collection<autoridad> autoridades = Arrays.asList(new autoridad("ROLE_USER"), new autoridad("ROLE_ADMIN"));
        usuario user = new usuario("John", "Doe", 123456789, "john.doe@example.com", "password123");

        user.setAutoridades(autoridades);

        assertEquals(autoridades, user.getAutoridades());
    }

}
