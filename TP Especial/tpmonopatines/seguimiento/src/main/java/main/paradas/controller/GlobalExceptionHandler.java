package main.paradas.controller;

import main.paradas.dtos.ErrorDTO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ErrorDTO get(RuntimeException ex) {
        return new ErrorDTO(ex.getMessage());
    }
}
