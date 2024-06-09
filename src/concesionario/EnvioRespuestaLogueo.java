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
class EnvioRespuestaLogueo implements Serializable{
    private String respuesta;
    private boolean correcto;
    private Usuario usuario;
    
    public EnvioRespuestaLogueo(String respuesta, boolean correcto,Usuario usuario) {
        this.respuesta = respuesta;
        this.correcto = correcto;
        this.usuario = usuario;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public boolean isCorrecto() {
        return correcto;
    }

    public void setCorrecto(boolean correcto) {
        this.correcto = correcto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
