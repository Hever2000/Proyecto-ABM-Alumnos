package com.abmalumnos.wrappers;

import com.abmalumnos.dataStructures.Usuario;

public class PassChangeWrapper {
    private Usuario usuario;
    private String nuevaContra;

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public String getNuevaContra() { return nuevaContra; }
    public void setNuevaContra(String nuevaContra) { this.nuevaContra = nuevaContra; }
}
