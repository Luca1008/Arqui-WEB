package main.paradas.controller;

import org.springframework.web.bind.annotation.*;
import main.paradas.servicios.paradaService;


@RestController
@RequestMapping("/parada")
public class paradaController {
    private final paradaService paradaService;

    public paradaController(paradaService paradaService) {
        this.paradaService = paradaService;
    }
}

