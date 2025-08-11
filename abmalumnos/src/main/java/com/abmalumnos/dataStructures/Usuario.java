package com.abmalumnos.dataStructures;

import jakarta.persistence.Entity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import jakarta.persistence.*;

@Entity
public class Usuario {
    @Id
    private Integer legajo;

    @OneToOne
    @JoinColumn(name = "legajo")
    private Alumno alumno;

    @Column(length = 256, nullable = false)
    private byte[] password;


    //#region setters

    public void setLegajo(Integer legajo) { this.legajo = legajo; }
    public Integer getLegajo() { return legajo; }

    public void setAlumno(Alumno alumno) { this.alumno = alumno; }

    public void setPassword(String password) {
        this.password = hashString(password);
    }

    //#endregion


    public boolean tryPassword(String password) {
        return this.password.equals(hashString(password));
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
