package main.mantenimiento.Dtos;

import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@RequiredArgsConstructor
public final class ErrorDTO {

    private final String message;
    private final LocalDate date = LocalDate.now();
}
