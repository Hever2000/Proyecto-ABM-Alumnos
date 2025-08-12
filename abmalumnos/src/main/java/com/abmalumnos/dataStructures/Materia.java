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
 * dia estas otras bases de datos
 */

@Entity
public class Materia {
    @Id
    private Integer codigoMateria;
    private String nombreMateria;

     //#region Getters

     public Integer getCodigoMateria() { return codigoMateria; }

     public String getNombreMateria() { return nombreMateria; }

     //#endregion
}
