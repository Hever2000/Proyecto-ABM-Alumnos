package com.abmalumnos;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Alumno {
    private String nombre;
    private String fechaNacimiento;
    
    @Id
    private String dni;

    private String correoUni;
    private String contacto;

    @ElementCollection
    private List<String> carreras;

    @ElementCollection
    private List<String> materiasEnCurso;

    @ElementCollection
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

    public List<String> getCarreras() { return carreras; }
    public void setCarrera(List<String> carreras) { this.carreras = carreras; }

    public List<String> getMateriasCursa() { return materiasEnCurso; }
    public void setMateriasCursa(List<String> materiasCursa) { this.materiasEnCurso = materiasCursa; }

    public List<String> getMateriasAprobadas() { return materiasAprobadas; }
    public void setMateriasAprobadas(List<String> materiasAprobadas) { this.materiasAprobadas = materiasAprobadas; }
}