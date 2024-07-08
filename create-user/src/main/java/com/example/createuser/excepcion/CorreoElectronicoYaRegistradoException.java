package com.example.createuser.excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CorreoElectronicoYaRegistradoException extends RuntimeException {

    public CorreoElectronicoYaRegistradoException() {
        super("El correo electrónico ya está registrado");
    }

    public CorreoElectronicoYaRegistradoException(String message) {
        super(message);
    }
}