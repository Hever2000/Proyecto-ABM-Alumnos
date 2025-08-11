package com.abmalumnos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.abmalumnos.dataStructures.Usuario;
import com.abmalumnos.exceptions.UsuarioYaExistenteException;
import com.abmalumnos.exceptions.UsuarioNotFoundException;
import com.abmalumnos.repository.UsuarioRepository;

@RestController
@RequestMapping("api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/register")
    public void agregarUsuario(@RequestBody Usuario usr) {
        if(usuarioRepository.existsById(usr.getLegajo())){
            throw new UsuarioYaExistenteException(
                String.format("El usuario %d intento crear un nuevo usuario", usr.getLegajo())
                );
        }

        usuarioRepository.save(usr);
    }

    @PutMapping("/recover")
    public void modificarUsuario(@RequestBody Usuario usr){
        if(!usuarioRepository.existsById(usr.getLegajo())){
            throw new UsuarioNotFoundException(
                String.format("El usuario %d no fue encontrado", usr.getLegajo())
            );
        }

        usuarioRepository.save(usr);
    }

    @DeleteMapping("/{legajo}")
    public void eliminarUsuario(@PathVariable("legajo") Integer legajo){
        if(!usuarioRepository.existsById(legajo)){
            throw new UsuarioNotFoundException(
                String.format("El usuario %d no fue encontrado", legajo)
            );
        }

        usuarioRepository.deleteById(legajo);
    }
}
