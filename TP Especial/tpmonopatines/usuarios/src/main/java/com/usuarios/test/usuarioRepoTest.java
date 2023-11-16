package com.usuarios.test;

import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.usuarios.repository.usuarioRepository;
import java.util.Optional;
import com.usuarios.model.usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@DataJpaTest
public class usuarioRepoTest {

    @Autowired
    private usuarioRepository usuarioRepository;

    @Test
    public void testFindUsuarioByEmailIgnoreCase() {
        // Crea un usuario y guárdalo en el repositorio
        usuario usuario = new usuario();
        usuario.setEmail("test@example.com");
        usuarioRepository.save(usuario);

        // Busca el usuario por correo electrónico (ignorando mayúsculas/minúsculas)
        Optional<usuario> usuarioEncontrado = usuarioRepository.findUsuarioByEmailIgnoreCase("TEST@example.com");

        // Verifica que el usuario se haya encontrado
        assertTrue(usuarioEncontrado.isPresent());
        assertEquals("test@example.com", usuarioEncontrado.get().getEmail());
    }

    @Test
    public void testExistsUsuariosByEmailIgnoreCase() {
        // Crea un usuario y guárdalo en el repositorio
        usuario usuario = new usuario();
        usuario.setEmail("test@example.com");
        usuarioRepository.save(usuario);

        // Verifica si existe un usuario por correo electrónico (ignorando
        // mayúsculas/minúsculas)
        boolean usuarioExiste = usuarioRepository.existsUsuariosByEmailIgnoreCase("TEST@example.com");

        // Verifica que el usuario exista
        assertTrue(usuarioExiste);
    }

    @Test
    public void testExistsUsuariosByEmailIgnoreCase_CuandoNoExiste() {
        // Verifica si existe un usuario por correo electrónico que no existe
        boolean usuarioExiste = usuarioRepository.existsUsuariosByEmailIgnoreCase("correoNoExistente@example.com");

        // Verifica que el usuario no exista
        assertFalse(usuarioExiste);
    }
}
