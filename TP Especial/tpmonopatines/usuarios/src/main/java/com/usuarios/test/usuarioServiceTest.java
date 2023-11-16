package com.usuarios.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.usuarios.repository.usuarioRepository;
import com.usuarios.Dtos.UserRequestDTO;
import com.usuarios.Dtos.UserResponseDTO;
import com.usuarios.repository.autoridadRepository;
import com.usuarios.repository.cuentaRepository;
import com.usuarios.servicios.usuarioService;
import com.usuarios.servicios.exception.user.UserException;

import org.springframework.web.client.RestTemplate;

public class usuarioServiceTest {

    private usuarioRepository usuarioRepository;
    private RestTemplate restTemplate;
    private cuentaRepository cuentaRepository;
    private autoridadRepository autoridadRepository;
    private PasswordEncoder passwordEncoder;
    private usuarioService usuarioService;

    @BeforeEach
    public void setUp() {
        usuarioRepository = mock(usuarioRepository.class);
        restTemplate = mock(RestTemplate.class);
        cuentaRepository = mock(cuentaRepository.class);
        autoridadRepository = mock(autoridadRepository.class);
        passwordEncoder = mock(PasswordEncoder.class);
        usuarioService = new usuarioService(restTemplate, cuentaRepository, autoridadRepository,
                passwordEncoder);
    }

    @Test
    public void testCreateUser_Success() {
        Set<Long> cuentas = new HashSet<>(Arrays.asList(1L, 2L, 3L));
        Set<String> authorities = new HashSet<>(Arrays.asList("ROLE_USER", "ROLE_ADMIN"));
        UserRequestDTO request = new UserRequestDTO("Nombre", "Apellido", "correo@example.com", "contrasena123",
                cuentas, authorities);
        ;
        List<Long> cuentaIds = Arrays.asList(1L, 2L);
        List<String> autoridadIds = Arrays.asList("ROLE_USER", "ROLE_ADMIN");
        when(usuarioRepository.existsUsuariosByEmailIgnoreCase(anyString())).thenReturn(false);
        when(cuentaRepository.findAllById(cuentaIds)).thenReturn(Arrays.asList(/* proporciona cuentas simuladas */));
        when(autoridadRepository.findById(anyString()))
                .thenReturn(Optional.of(/* proporciona una autoridad simulada */));
        when(passwordEncoder.encode(anyString())).thenReturn("hashedPassword");
        when(usuarioRepository.save(any())).thenReturn(/* proporciona el usuario simulado guardado */);
        UserResponseDTO response = usuarioService.createUser(request);
        assertNotNull(response);

    }

    @Test
    public void testCreateUser_UserAlreadyExists() {
        UserRequestDTO request = new UserRequestDTO(/* proporciona los datos necesarios */);
        when(usuarioRepository.existsUsuariosByEmailIgnoreCase(anyString())).thenReturn(true);
        assertThrows(UserException.class, () -> usuarioService.createUser(request));
    }

    @Test
    public void testCreateUser_InvalidAccounts() {
        UserRequestDTO request = new UserRequestDTO(/* proporciona los datos necesarios */);
        List<Long> cuentaIds = Collections.emptyList(); // Configura una lista de cuentas vacía

        when(usuarioRepository.existsUsuariosByEmailIgnoreCase(anyString())).thenReturn(false);
        when(cuentaRepository.findAllById(cuentaIds)).thenReturn(Collections.emptyList());

        assertThrows(UserException.class, () -> usuarioService.createUser(request));
    }

    @Test
    public void testCreateUser_InvalidAuthorities() {

        UserRequestDTO request = new UserRequestDTO(/* proporciona los datos necesarios */);
        List<String> autoridadIds = Collections.emptyList(); // Configura una lista de autoridades vacía

        when(usuarioRepository.existsUsuariosByEmailIgnoreCase(anyString())).thenReturn(false);
        when(cuentaRepository.findAllById(anyList())).thenReturn(Arrays.asList(/* proporciona cuentas simuladas */));
        when(autoridadRepository.findById(anyString())).thenReturn(Optional.empty());

        assertThrows(UserException.class, () -> usuarioService.createUser(request));
    }
}
