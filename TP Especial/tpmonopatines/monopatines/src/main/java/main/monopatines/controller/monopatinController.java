package main.monopatines.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Monopatin")
public class MonopatinControllerJpa {
    @Qualifier("MonopatinServicio")
    @Autowired
    private final MonopatinServicio Servicio;

    public MonopatinControllerJpa(@Qualifier("MonopatinServicio") MonopatinServicio Servicio) {
        this.Servicio = Servicio;
    }
}