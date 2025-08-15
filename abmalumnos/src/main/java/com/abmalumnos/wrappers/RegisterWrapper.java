package com.abmalumnos.wrappers;

import com.abmalumnos.dataStructures.Alumno;

public class RegisterWrapper {
    private Alumno alumno;
    private String contra;

    public Alumno getAlumno() { return alumno; }
    public void setAlumno(Alumno alumno) { this.alumno = alumno; }

    public String getContra() { return contra; }
    public void setContra(String contra) { this.contra = contra; }
}
