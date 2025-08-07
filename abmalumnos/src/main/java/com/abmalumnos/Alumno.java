package com.abmalumnos;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Alumno {
    @Id // Marca al legajo como llave primaria
    private String legajo;
    private String nombre;
    private String dni;
    private String fechaNacimiento;
    private String direccion;
    private String contacto;
    private String correoUni;

    @ElementCollection
    private List<String> carreras;

    @ElementCollection
    private List<String> materiasAprobadas;

    @ElementCollection
    private List<String> materiasEnCurso;

    //#region Getters y setters

    public String getLegajo() { return legajo; }
    public void setLegajo(String legajo) { this.legajo = legajo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(String fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getContacto() { return contacto; }
    public void setContacto(String contacto) { this.contacto = contacto; }

    public String getCorreoUni() { return correoUni; }
    public void setCorreoUni(String correoUni) { this.correoUni = correoUni; }

    public List<String> getCarreras() { return carreras; }
    public void setCarrera(List<String> carreras) { this.carreras = carreras; }

    public List<String> getMateriasAprobadas() { return materiasAprobadas; }
    public void setMateriasAprobadas(List<String> materiasAprobadas) { this.materiasAprobadas = materiasAprobadas; }

    public List<String> getMateriasCursa() { return materiasEnCurso; }
    public void setMateriasCursa(List<String> materiasCursa) { this.materiasEnCurso = materiasCursa; }
    
    //#endregion
}