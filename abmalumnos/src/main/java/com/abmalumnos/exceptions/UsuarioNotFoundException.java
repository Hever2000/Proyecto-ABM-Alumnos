package com.abmalumnos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Alumno no encontrado")
public class UsuarioNotFoundException extends RuntimeException {

    public UsuarioNotFoundException(){
        super();
    }

    public UsuarioNotFoundException(String message){
        super(message);
    }

}
