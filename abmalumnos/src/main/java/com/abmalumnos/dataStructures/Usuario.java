package com.abmalumnos.dataStructures;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class Usuario {
    @Id
    @Column(nullable = false)
    private Integer legajo;

    @OneToOne
    @JoinColumn(name = "legajo")
    private Alumno alumno;

    @Column(length = 256, nullable = false)
    private byte[] password;

    @Column(nullable = false)
    private boolean esAdmin;

    public Usuario() {}

    public Usuario(Integer legajo, String password){
        this.legajo = legajo;
        this.setPassword(password);
    }

    //#region getters y setters

    public Integer getLegajo() { return legajo; }
    public void setLegajo(Integer legajo) { this.legajo = legajo; }

    @JsonIgnore
    public Alumno getAlumno() { return alumno; }
    public void setAlumno(Alumno alumno) { this.alumno = alumno; }

    @JsonIgnore
    public byte[] getPassword() { return this.password; }
    public void setPassword(String password) {
        this.password = hashString(password);
    }
    
    public boolean getEsAdmin(){ return esAdmin; }

    //#endregion


    public boolean tryPassword(String password) {
        return Arrays.equals(this.password, hashString(password));
    }


    private byte[] hashString(String toHash) {
        byte[] ret = null;

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            ret = md.digest(toHash.getBytes());

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return ret;
    }
}
