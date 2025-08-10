package com.abmalumnos.dataStructures;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.abmalumnos.repository.MateriaRepository;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/*
 * Segun lo especificado por la documentacion, esta clase no
 * contiene ningun tipo de comportamiento asociado al front,
 * por lo cual esta no tiene un controlador/API asociada
 * 
 * En terminos de que decirle a la profe: Nosotros nos
 * encargamos del sistema de altas, bajas, y modificaciones
 * a cuentas de alumnos. Mientras que usamos estas bases de
 * datos, estas estan por fuera del limite de nuestro sistema
 * y se asume que hay otro sistema que manipula y mantiene al
 * dia estas otras bases de datos
 */

@Entity
public class Materia {
    @Id
    private Integer codigoMateria;
    private String nombreMateria;

    @Autowired
    private static MateriaRepository materiaRepository;

     //#region Getters

     public Integer getCodigoMateria() { return codigoMateria; }

     public String getNombreMateria() { return nombreMateria; }

    // Devuelve los nombres canoncios de las materias pasadas por parametro
     public static List<String> getNombreMaterias(String[] codMateria) {
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
                    .printStackTrace();;
            }
        }

        return ret;
    }

     //#endregion
}
