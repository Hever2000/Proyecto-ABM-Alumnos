package com.abmalumnos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.abmalumnos.dataStructures.Usuario;
import com.abmalumnos.exceptions.WrongPasswordException;
import com.abmalumnos.exceptions.UsuarioNotFoundException;
import com.abmalumnos.repository.UsuarioRepository;
import com.abmalumnos.wrappers.LoginDataWrapper;
import com.abmalumnos.wrappers.PassChangeWrapper;
import com.abmalumnos.wrappers.RegisterWrapper;

@RestController
@RequestMapping("api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/register")
    public void agregarUsuario(@RequestBody RegisterWrapper rw) {
        // Tira 400 si ya existe (x dni)
        Integer legajo = AlumnoController.getInstance().agregarAlumno(rw.getAlumno());

        // Creo y guardo al usuario
        Usuario usr = new Usuario(legajo, rw.getContra());
        usuarioRepository.save(usr);
        
        // Retorna 200 OK
    }

    @PutMapping("/changePass")
    public void modificarUsuario(@RequestBody PassChangeWrapper pcw){
        Usuario tmp = usuarioRepository.findById(pcw.getLoginData().getLegajo()).orElse(null);

        if(tmp == null){
            // Retorna 404 NOT FOUND
            throw new UsuarioNotFoundException(
                String.format("El usuario %d no fue encontrado", pcw.getLoginData().getLegajo())
            );
        }

        if (tmp.tryPassword(pcw.getLoginData().getContra())) {
            // Retorna 401 UNAUTHORIZED
            throw new WrongPasswordException();
        }

        //Actualizo solo la contra del usuario
        tmp.setPassword(pcw.getNuevaContra());
        
        usuarioRepository.save(tmp);
        
        // Retorna 200 OK
    }

    @GetMapping("/login")
    public void iniciarSesion(@RequestBody LoginDataWrapper loginData){
        Usuario usr = usuarioRepository.findById(loginData.getLegajo()).orElse(null);

        if(usr == null)
            // Retorna 404 NOT FOUND
            throw new UsuarioNotFoundException(
                String.format("El usuario %d no fue encontrado", loginData.getLegajo())
            );

        if (!usr.tryPassword(loginData.getContra())) {
            // Retorna 401 UNAUTHORIZED
            throw new WrongPasswordException();
        }
        
        // Retorna 200 OK
    }

    @DeleteMapping("/delete")
    public void eliminarUsuario(@RequestBody LoginDataWrapper loginData){
        Usuario usr = usuarioRepository.findById(loginData.getLegajo()).orElse(null);

        if(usr == null)
            // Retorna 404 NOT FOUND
            throw new UsuarioNotFoundException(
                String.format("El usuario %d no fue encontrado", loginData.getLegajo())
            );

        if (!usr.tryPassword(loginData.getContra())) {
            // Retorna 401 UNAUTHORIZED
            throw new WrongPasswordException();
        }

        usuarioRepository.deleteById(loginData.getLegajo());
        
        // Retorna 200 OK
    }
}
