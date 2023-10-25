package main.mantenimiento.controller;

import org.springframework.web.bind.annotation.*;
import main.mantenimiento.model.mantenimiento;
import main.mantenimiento.servicios.mantenimientoService;


@RestController
@RequestMapping("/mantenimiento")
public class mantenimientoController {
    private final mantenimientoService mantenimientoService;

    public mantenimientoController(mantenimientoService mantenimientoService) {
        this.mantenimientoService = mantenimientoService;
    }
}
