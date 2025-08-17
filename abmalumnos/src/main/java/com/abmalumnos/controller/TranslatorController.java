package com.abmalumnos.controller;

import java.util.List;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.abmalumnos.dataStructures.Carrera;
import com.abmalumnos.dataStructures.Materia;
import com.abmalumnos.repository.CarreraRepository;
import com.abmalumnos.repository.MateriaRepository;

@RestController
@RequestMapping("/api/translate")
@CrossOrigin(origins = "*")
public class TranslatorController {

     @Autowired
     private CarreraRepository carreraRepository;

     @Autowired
     private MateriaRepository materiaRepository;

    
    // Devuelve los nombres canoncios de las carreas pasadas por parametro
    @GetMapping("/carreras")
    public @ResponseBody List<String> getNombreCarreras(@RequestParam("codigos") String[] codCarrera) {
        LinkedList<String> ret = new LinkedList<>();

        for (int i = 0; i < codCarrera.length; i++) {
            Carrera tmp = carreraRepository.findById(Integer.parseInt(codCarrera[i]))
                                            .orElse(null);

            if (tmp != null) {
                ret.add(tmp.getNombreCarrera());
            } else {
                new Exception(String.format(
                    "Carrera invalida detectada\nCodigo de carrera invalida: %s\n",
                    codCarrera[i]))
                    .printStackTrace();
            }
        }

        return ret;
    }

    @GetMapping("/materias")
    // Devuelve los nombres canoncios de las materias pasadas por parametro
     public @ResponseBody List<String> getNombreMaterias(@RequestParam("codigos") String[] codMateria) {
        LinkedList<String> ret = new LinkedList<>();

        for (int i = 0; i < codMateria.length; i++) {
            Materia tmp = materiaRepository.findById(Integer.parseInt(codMateria[i]))
                                            .orElse(null);
            
            if (tmp != null) {
                ret.add(tmp.getNombreMateria());
            } else {
                new Exception(String.format(
                    "Materia invalida detectada\nCodigo de materia invalida: %s\n",
                    codMateria[i]))
                    .printStackTrace();
            }
        }

        return ret;
    }

    @GetMapping("/all/carreras")
    public @ResponseBody Iterable<Carrera> getAllCarreras(){
        return carreraRepository.findAll();
    }

    @GetMapping("/all/materias")
    public @ResponseBody Iterable<Materia> getAllMaterias(){
        return materiaRepository.findAll();
    }
}
