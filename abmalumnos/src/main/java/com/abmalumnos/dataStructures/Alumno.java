package com.abmalumnos.dataStructures;

import jakarta.persistence.*;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(indexes = {
    @Index(columnList = "dni")
})
public class Alumno {
    @Id // Marca al legajo como llave primaria
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(updatable = false, nullable = false, unique = true)
    private Integer legajo;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String dni;
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(nullable = false)
    private Date fechaNacimiento;
    @Column(nullable = false)
    private String direccion;
    // Opcional, puede ser null
    private String contacto;
    @Column(nullable = false)
    private String correoUni;
    @Column(nullable = false)
    private String carreras;
    @Column(nullable = false)
    private String materiasAprobadas;
    @Column(nullable = false)
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

    public String getCarreras() { return carreras; }

    public void setCarrera(String carreras) {
        this.carreras = carreras;
    }

    public String getMateriasAprobadas() { return materiasAprobadas; }

    public void setMateriasAprobadas(String materiasAprobadas) {
        this.materiasAprobadas = materiasAprobadas;
    }

    public String getMateriasCursa() { return materiasEnCurso; }

    public void setMateriasCursa(String materiasCursa) { 
        this.materiasEnCurso = materiasCursa;
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
        ret.carreras = this.carreras;
        ret.materiasEnCurso = this.materiasEnCurso;

        return ret;
    }

    //#endregion
}