package com.example.createuser.excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CorreoElectronicoInvalidoException extends RuntimeException {

    public CorreoElectronicoInvalidoException() {
        super("El correo electrónico ya está registrado");
    }

    public CorreoElectronicoInvalidoException(String message) {
        super(message);
    }
}