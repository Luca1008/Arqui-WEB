package main.paradas.controller;

@RestController
@RequestMapping("/parada")
public class paradaController {
    private final paradaService paradaService;

    public paradaController(paradaService paradaService) {
        this.paradaService = paradaService;
    }
}

