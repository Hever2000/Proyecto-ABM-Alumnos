package com.abmalumnos.controller;

import com.abmalumnos.dataStructures.Alumno;
import com.abmalumnos.exceptions.AlumnoNotFoundException;
import com.abmalumnos.exceptions.UsuarioYaExistenteException;
import com.abmalumnos.repository.AlumnoRepository;

import java.util.Iterator;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/alumnos")
@CrossOrigin(origins = "*")
public class AlumnoController {

    //#region Singleton pattern
    private static AlumnoController self;

    public static AlumnoController getInstance(){
        return self;
    }

    //#endregion

    public AlumnoController(){
        //Singleton setup
        if(self != null){
            System.err.println("Ya existe una instancia de Alumno Controller");
            return;
        }

        self = this;
    }

    @Autowired
    private AlumnoRepository alumnoRepository;

    //@PostMapping("/register") -- Deshabilitado el endpoint
    public Integer agregarAlumno(Alumno alumno) {
        // Busco duplicados
        if (alumnoRepository.findBydni(alumno.getDni()).orElse(null) != null) {
            throw new UsuarioYaExistenteException();
        }

        //Guardo y se genera el ID (legajo)
        alumnoRepository.save(alumno);

        //Retorno el legajo
        return alumno.getLegajo();
    }

    // Solo manda los datos publicos como nombre, correo, y carrera
    @GetMapping("/all")
    public @ResponseBody Iterable<Alumno> obtenerTodosLosAlumnos(){
        // Creo una lista de objetos Alumnos
        LinkedList<Alumno> ret = new LinkedList<Alumno>();

        // Agarro el iterador de alumnoRepository para poder ir por todos los elementos
        Iterator<Alumno> it = alumnoRepository.findAll().iterator();
        
        // Mientras tenga cosas
        while (it.hasNext()) {
            // Lo meto a la lista, pero solo los datos publicos
            ret.add(it.next().getPublicData());
        }

        // Retorno la lista, que es un Iterable (Lo manda como json)
        return ret;
    }

    // Manda todos los datos de la clase alumno, con los nombres
    @GetMapping("/{legajo}")
    public @ResponseBody Alumno obtenerAlumno(@PathVariable("legajo") Integer legajo) {
        Alumno ret = alumnoRepository.findById(legajo).orElse(null);

        if (ret == null) throw new AlumnoNotFoundException(
                String.format("Alumno con legajo %d no fue encontrado", legajo)
                );

        return ret;
    }

    // Sobreescribe al alumno de legajo X con la informacion nueva
    @PutMapping("/{legajo}")
    public void modificarAlumno(@PathVariable("legajo") Integer legajo, @RequestBody Alumno alumno){
        if (!alumnoRepository.existsById(legajo))
            throw new AlumnoNotFoundException(
                String.format("Alumno con legajo %d no fue encontrado", legajo)
            );

        alumnoRepository.save(alumno);
    }

    // Elimina al alumno de legajo X
    //@DeleteMapping("/{legajo}") // Cerrado ya que un alumno no deberia ser eliminado sin su usuario
    public void eliminarAlumno(Integer legajo){
        if (!alumnoRepository.existsById(legajo))
            throw new AlumnoNotFoundException(
                String.format("Alumno con legajo %d no fue encontrado", legajo)
            );
        
        alumnoRepository.deleteById(legajo);
    }
}