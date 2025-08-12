package com.abmalumnos.dataStructures;

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
    
    //#region Getters

    public Integer getCodigoCarrera() { return codigoCarrera; }

    public String getNombreCarrera() { return nombreCarrera; }

    //#endregion
}
