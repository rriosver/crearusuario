package com.example.createuser.excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NombreInvalidoException extends RuntimeException {

    public NombreInvalidoException() {
        super("Nombre de usuario invalido");
    }

    public NombreInvalidoException(String message) {
        super(message);
    }
}