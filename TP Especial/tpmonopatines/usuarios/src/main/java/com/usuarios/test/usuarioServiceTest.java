package com.usuarios.test;

import com.usuarios.Dtos.DtoUsuario;
import com.usuarios.model.usuario;
import com.usuarios.repository.usuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@DataJpaTest
public class usuarioServiceTest {

    @Autowired
    private usuarioRepository usuarioRepository;

    @Test
    @Transactional
    public void testFindById_Exists() {
        usuario savedUser = new usuario();
        savedUser.setNombre("John");
        savedUser.setApellido("Doe");
        savedUser.setCelular(123456789);
        savedUser.setEmail("john.doe@example.com");
        usuarioRepository.save(savedUser);

        Long userId = savedUser.getId();
        DtoUsuario result = usuarioRepository.findById(userId).map(user -> new DtoUsuario(user.getId(),
                user.getNombre(), user.getApellido(), user.getCelular(), user.getEmail())).orElse(null);
        assertEquals(userId, result.getId());
        assertEquals("John", result.getNombre());
        assertEquals("Doe", result.getApellido());
        assertEquals(123456789, result.getCelular());
        assertEquals("john.doe@example.com", result.getEmail());
    }

    @Test
    @Transactional
    public void testFindById_NotExists() {
        Long nonExistentUserId = 100L;
        DtoUsuario result = usuarioRepository.findById(nonExistentUserId).map(user -> new DtoUsuario(user.getId(),
                user.getNombre(), user.getApellido(), user.getCelular(), user.getEmail())).orElse(null);
        assertNull(result);
    }

}
