package com.abmalumnos;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

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

    public String getCarreras() { return carreras; }
    public void setCarrera(String carreras) { this.carreras = carreras; }

    public String getMateriasAprobadas() { return materiasAprobadas; }
    public void setMateriasAprobadas(String materiasAprobadas) { this.materiasAprobadas = materiasAprobadas; }

    public String getMateriasCursa() { return materiasEnCurso; }
    public void setMateriasCursa(String materiasCursa) { this.materiasEnCurso = materiasCursa; }

    /*
     * Solo manda los datos publicos como nombre, correo, y carrera
     * 
     * Sepan que la profe de progra seguro los mata si hacen esto asi.
     * Usen constructores y no tanto setter a menos que quieran que
     * el dato sea mutable (no es nuestro caso)
     */ 
    public Alumno getPublicData() {
        Alumno ret = new Alumno();

        ret.nombre = this.nombre;
        ret.correoUni = this.correoUni;
        ret.carreras = this.carreras;

        return ret;
    }

    // Devuelve los nombres canoncios de las carreas de las que es parte
    public List<String> getNombreCarreras() {
        return Carrera.getNombreCarreras(this.carreras.split(","));
    }

    // Devuelve los nombres canonicos de las materias que aprobo
    public List<String> getNombreMateriasAprobadas() {
        return Materia.getNombreMaterias(this.materiasAprobadas.split(","));
    }

    // Devuelve los nombres canonicos de las materias que cursa
    public List<String> getNombreMateriasCursa() {
        return Materia.getNombreMaterias(this.materiasEnCurso.split(","));
    }

    //#endregion
}