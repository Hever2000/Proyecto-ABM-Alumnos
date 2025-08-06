package com.abmalumnos.controller;

import com.abmalumnos.Alumno;
import com.abmalumnos.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/alumnos")
@CrossOrigin(origins = "*")
public class AlumnoController {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @PostMapping("/Register")
    public String agregarAlumno(@RequestBody Alumno alumno) {
        alumnoRepository.save(alumno);
        return "Alumno agregado: " + alumno.getNombre();
    }

    @GetMapping("/{dni}")
    public Alumno obtenerAlumno(@PathVariable String dni) {
        return alumnoRepository.findById(dni).orElse(null);
    }
}