package com.abmalumnos.wrappers;

public class PassChangeWrapper {
    private LoginDataWrapper loginData;
    private String nuevaContra;

    public LoginDataWrapper getLoginData() { return loginData; }
    public void setUsuario(LoginDataWrapper loginData) { this.loginData = loginData; }

    public String getNuevaContra() { return nuevaContra; }
    public void setNuevaContra(String nuevaContra) { this.nuevaContra = nuevaContra; }
}
