package com.abmalumnos.dataStructures;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.abmalumnos.repository.CarreraRepository;

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
 * dia estas bases de datos
 */

@Entity
public class Carrera {
    @Id
    private Integer codigoCarrera;
    private String nombreCarrera;

    @Autowired
    private static CarreraRepository carreraRepository;
    
    //#region Getters

    public Integer getCodigoCarrera() { return codigoCarrera; }

    public String getNombreCarrera() { return nombreCarrera; }

    // Devuelve los nombres canoncios de las carreas pasadas por parametro
    public static List<String> getNombreCarreras(String[] codCarrera) {
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
                    .printStackTrace();;
            }
        }

        return ret;
    }

    //#endregion
}
