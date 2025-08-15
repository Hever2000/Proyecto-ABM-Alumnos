package com.abmalumnos.controller;

import org.springframework.web.bind.annotation.*;

import com.abmalumnos.dataStructures.*;
import com.abmalumnos.wrappers.*;

@RestController
@RequestMapping("/api/test")
@CrossOrigin(origins = "*")
public class TestController {

    //#region Estructuras

    @GetMapping("/alumno")
    public @ResponseBody Alumno getAlumnoStructure() { return new Alumno(); }

    @GetMapping("/carrera")
    public @ResponseBody Carrera getCarreraStructure() { return new Carrera(); }

    @GetMapping("/materia")
    public @ResponseBody Materia getMateriaStructure() { return new Materia(); }

    @GetMapping("/usuario")
    public @ResponseBody Usuario getUsuarioStructure() { return new Usuario(); }

    //#endregion

    //#region Wrappers

    @GetMapping("/logindata")
    public @ResponseBody LoginDataWrapper getLoginDataWrapperStructure() { return new LoginDataWrapper(); }

    @GetMapping("/passchange")
    public @ResponseBody PassChangeWrapper getPassChangeWrapperStructure() {
        PassChangeWrapper pcd = new PassChangeWrapper();
        pcd.setLoginData(getLoginDataWrapperStructure());;
        return pcd;
    }

    @GetMapping("/register")
    public @ResponseBody RegisterWrapper getRegisterWrapperStructure() {
        RegisterWrapper rw = new RegisterWrapper();
        rw.setAlumno(getAlumnoStructure());
        return rw;
    }

    //#endregion
}
