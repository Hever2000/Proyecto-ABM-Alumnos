package com.abmalumnos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Alumno no encontrado")
public class AlumnoNotFoundException extends RuntimeException {
    
    public AlumnoNotFoundException(){
        super();
    }

    public AlumnoNotFoundException(String message){
        super(message);
    }
}
