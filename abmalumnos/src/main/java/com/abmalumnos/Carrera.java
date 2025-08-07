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
 * dia estas bases de datos
 */

@Entity
public class Carrera {
    @Id
    private Integer codigoCarrera;
    private String nombreCarrera;

    /*
     * La clase tiene que ser inmutable, los datos se obtienen
     * de la DB, cuando se llama al constructor de la clase, y
     * luego todo tiene que ser operaciones read-only (getters)
     */

    public Carrera(){
        // TODO: Conectar esto a la base de datos, o pasarle las cosas por parametro
        this.codigoCarrera = 101010;
        this.nombreCarrera = "Lorem Ipsum Dorime Ameno Patricio Estrella";
    }

    //#region Getters

    public Integer getCodigoCarrera() { return codigoCarrera; }

    public String getNombreCarrera() { return nombreCarrera; }

    //#endregion
}
