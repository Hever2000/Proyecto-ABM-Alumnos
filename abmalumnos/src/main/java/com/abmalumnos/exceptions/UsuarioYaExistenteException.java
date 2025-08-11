package com.abmalumnos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "El usuario ya existe en la base de datos")
public class UsuarioYaExistenteException extends RuntimeException {

    public UsuarioYaExistenteException(){
        super();
    }

    public UsuarioYaExistenteException(String message){
        super(message);
    }
}
