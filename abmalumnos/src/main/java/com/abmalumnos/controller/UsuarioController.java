package com.abmalumnos.controller;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.abmalumnos.dataStructures.Usuario;
import com.abmalumnos.exceptions.UsuarioYaExistenteException;
import com.abmalumnos.exceptions.WrongPasswordException;
import com.abmalumnos.exceptions.UsuarioNotFoundException;
import com.abmalumnos.repository.UsuarioRepository;
import com.abmalumnos.wrappers.PassChangeWrapper;

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

    @PutMapping("/changePass")
    public void modificarUsuario(@RequestBody PassChangeWrapper pcw){
        Usuario tmp = usuarioRepository.findById(pcw.getUsuario().getLegajo()).orElse(null);

        if(tmp == null){
            throw new UsuarioNotFoundException(
                String.format("El usuario %d no fue encontrado", pcw.getUsuario().getLegajo())
            );
        }

        if (tmp.tryPassword(new String(pcw.getUsuario().getPassword(), StandardCharsets.UTF_8))) {
            throw new WrongPasswordException();
        }

        //Actualizo solo la contra del usuario
        tmp.setPassword(pcw.getNuevaContra());
        
        usuarioRepository.save(tmp);
    }

    @GetMapping("/login/{legajo}")
    public @ResponseBody boolean iniciarSesion(@PathVariable("legajo") Integer legajo, @RequestBody String pass){
        Usuario usr = usuarioRepository.findById(legajo).orElse(null);

        if(usr == null)
            throw new UsuarioNotFoundException(
                String.format("El usuario %d no fue encontrado", legajo)
            );

        if (!usr.tryPassword(pass)) {
            throw new WrongPasswordException();
        }

        return true;
    }

    @DeleteMapping("/delete/{legajo}")
    public void eliminarUsuario(@PathVariable("legajo") Integer legajo, @RequestBody String pass){
        Usuario usr = usuarioRepository.findById(legajo).orElse(null);

        if(usr == null)
            throw new UsuarioNotFoundException(
                String.format("El usuario %d no fue encontrado", legajo)
            );

        if (!usr.tryPassword(pass)) {
            throw new WrongPasswordException();
        }

        usuarioRepository.deleteById(legajo);
    }
}
