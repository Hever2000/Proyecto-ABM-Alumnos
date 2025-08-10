package com.abmalumnos.dataStructures;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Alumno {
    @Id // Marca al legajo como llave primaria
    private Integer legajo;
    private String nombre;
    private String dni;
    private Date fechaNacimiento;
    private String direccion;
    private String contacto;
    private String correoUni;
    private String carreras;
    private String materiasAprobadas;
    private String materiasEnCurso;

    //#region Getters y setters

    public Integer getLegajo() { return legajo; }
    public void setLegajo(Integer legajo) { this.legajo = legajo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public Date getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(Date fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getContacto() { return contacto; }
    public void setContacto(String contacto) { this.contacto = contacto; }

    public String getCorreoUni() { return correoUni; }
    public void setCorreoUni(String correoUni) { this.correoUni = correoUni; }

    /*
     * Carreras y materias puestas con JSON ignore asi devuelve
     * los nombres de las materias, y no los codigos
    */ 

    @JsonIgnore
    public String getCarreras() { return carreras; }

    // Devuelve los nombres canoncios de las carreas de las que es parte
    public List<String> getNombreCarreras() {
        return Carrera.getNombreCarreras(this.carreras.split(","));
    }

    public void setCarrera(String nombreCarreras) {
        this.carreras = "";
        for (Integer codCarrera : Carrera.getCarreras(nombreCarreras.split(","))) {
            this.carreras += String.format("%d,", codCarrera);
        }
    }

    @JsonIgnore
    public String getMateriasAprobadas() { return materiasAprobadas; }

    // Devuelve los nombres canonicos de las materias que aprobo
    public List<String> getNombreMateriasAprobadas() {
        return Materia.getNombreMaterias(this.materiasAprobadas.split(","));
    }

    public void setMateriasAprobadas(String materiasAprobadas) {
        this.materiasAprobadas = "";
        for (Integer codMateria : Materia.getMaterias(materiasAprobadas.split(","))) {
            this.materiasAprobadas += String.format("%d,", codMateria);
        }
    }

    @JsonIgnore
    public String getMateriasCursa() { return materiasEnCurso; }

    // Devuelve los nombres canonicos de las materias que cursa
    public List<String> getNombreMateriasCursa() {
        return Materia.getNombreMaterias(this.materiasEnCurso.split(","));
    }

    public void setMateriasCursa(String materiasCursa) { 
        this.materiasEnCurso = "";
        for (Integer codMateria : Materia.getMaterias(materiasCursa.split(","))) {
            this.materiasEnCurso += String.format("%d,", codMateria);
        }
     }

    /*
     * Solo manda los datos publicos como nombre, correo, y los 
     * nombres de las carreras que esta subscripto
     * 
     * Sepan que la profe de progra seguro los mata si hacen esto asi.
     * Usen constructores y no tanto setter a menos que quieran que
     * el dato sea mutable (no es nuestro caso)
     */ 
    @JsonIgnore
    public Alumno getPublicData() {
        Alumno ret = new Alumno();

        ret.nombre = this.nombre;
        ret.correoUni = this.correoUni;
        ret.carreras = String.join(",", this.getNombreCarreras());

        return ret;
    }

    //#endregion
}