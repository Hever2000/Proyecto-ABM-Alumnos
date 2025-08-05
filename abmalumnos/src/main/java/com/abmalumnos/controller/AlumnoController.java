package com.abmalumnos.controller;

import com.abmalumnos.Alumno;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/alumnos")
@CrossOrigin(origins = "*")
public class AlumnoController {

    // Simulamos una base de datos en memoria
    private Map<String, Alumno> alumnos = new HashMap<>();

    @GetMapping("/{dni}")
    public Alumno obtenerAlumno(@PathVariable String dni) {
        return alumnos.get(dni);
    }

    @PostMapping("/Register")
    public String agregarAlumno(@RequestBody Alumno alumno) {
        alumnos.put(alumno.getDni(), alumno);
        return "Alumno agregado: " + alumno.getNombre();
    }
}
