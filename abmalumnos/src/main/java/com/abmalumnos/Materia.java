package com.abmalumnos;

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

    /*
     * La clase tiene que ser inmutable, los datos se obtienen
     * de la DB, cuando se llama al constructor de la clase, y
     * luego todo tiene que ser operaciones read-only (getters)
     */

     public Materia(){
        // TODO: Conectar esto a la base de datos, o pasarle las cosas por parametro
        this.codigoMateria = 010101;
        this.nombreMateria = "Lorem Ipsum Quis custodiet ipsos custodes";
     }

     //#region Getters

     public Integer getCodigoMateria() { return codigoMateria; }

     public String getNombreMateria() { return nombreMateria; }
     //#endregion
}
