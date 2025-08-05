package com.abmalumnos;

import java.util.List;

public class Alumno {
    private String nombre;
    private String fechaNacimiento;
    private String dni;
    private String correoUni;
    private String contacto;
    private String carrera;
    private List<String> materiasCursa;
    private List<String> materiasAprobadas;

    // Getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(String fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getCorreoUni() { return correoUni; }
    public void setCorreoUni(String correoUni) { this.correoUni = correoUni; }

    public String getContacto() { return contacto; }
    public void setContacto(String contacto) { this.contacto = contacto; }

    public String getCarrera() { return carrera; }
    public void setCarrera(String carrera) { this.carrera = carrera; }

    public List<String> getMateriasCursa() { return materiasCursa; }
    public void setMateriasCursa(List<String> materiasCursa) { this.materiasCursa = materiasCursa; }

    public List<String> getMateriasAprobadas() { return materiasAprobadas; }
    public void setMateriasAprobadas(List<String> materiasAprobadas) { this.materiasAprobadas = materiasAprobadas; }
}