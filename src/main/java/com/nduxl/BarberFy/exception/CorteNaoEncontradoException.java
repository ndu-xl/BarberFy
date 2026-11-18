package com.nduxl.BarberFy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CorteNaoEncontradoException extends RuntimeException {

    public CorteNaoEncontradoException(Long id) {
        super("Corte "+id+" não encontrado");
    }
}
