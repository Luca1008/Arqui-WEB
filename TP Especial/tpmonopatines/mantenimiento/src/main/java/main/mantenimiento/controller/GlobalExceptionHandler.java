package main.mantenimiento.controller;

import main.mantenimiento.Dtos.ErrorDTO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ErrorDTO get(RuntimeException ex) {
        return new ErrorDTO(ex.getMessage());
    }
}
