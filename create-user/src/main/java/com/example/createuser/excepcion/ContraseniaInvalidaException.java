package com.example.createuser.excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ContraseniaInvalidaException extends RuntimeException {

    public ContraseniaInvalidaException() {
        super("La contraseña debe tener al menos 8 caracteres, incluyendo una letra mayúscula, una letra minúscula y dos números");
    }

    public ContraseniaInvalidaException(String message) {
        super(message);
    }
}