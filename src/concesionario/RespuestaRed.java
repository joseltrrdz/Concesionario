/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package concesionario;

import java.io.Serializable;

/**
 *
 * @author jose-
 */
class RespuestaRed implements Serializable{
    private String modelo;
    private boolean aceptar;
    public RespuestaRed(String modelo, boolean aceptar) {
        this.modelo = modelo;
        this.aceptar=aceptar;
    }
    
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public boolean isAceptar() {
        return aceptar;
    }

    public void setAceptar(boolean aceptar) {
        this.aceptar = aceptar;
    }
    
    
}
