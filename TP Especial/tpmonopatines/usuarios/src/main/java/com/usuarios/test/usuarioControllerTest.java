package com.usuarios.test;
import com.usuarios.Dtos.DtoUsuario;
import com.usuarios.servicios.usuarioService;
import com.usuarios.controller.usuarioController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.mockito.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;


public class usuarioControllerTest {

    @Mock
    private usuarioService usuarioService;

    @InjectMocks
    private usuarioController usuarioController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAll() throws Exception {
        // Mock de la lista de usuarios esperada
        List<DtoUsuario> usuarios = new ArrayList<>();
        usuarios.add(new DtoUsuario());
        usuarios.add(new DtoUsuario());
        // Simular el comportamiento del servicio al llamar a findAll
        when(usuarioService.findAll()).thenReturn(usuarios);

        // Llamar al método del controlador y verificar la respuesta
        ResponseEntity<List<DtoUsuario>> response = usuarioController.findAll();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size()); // Verificar que se devuelvan 2 usuarios en la lista
    }

}
