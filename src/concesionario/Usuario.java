/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package concesionario;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author jose-
 */
public class Usuario implements Serializable{
    private String usuario;
    private String clave;
    private double dinero;
    private ArrayList<Coche> coches;

    public Usuario(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
        this.dinero=100;
        this.coches = new ArrayList<Coche>();
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public ArrayList<Coche> getCoches() {
        return coches;
    }

    public void setCoches(ArrayList<Coche> coches) {
        this.coches = coches;
    }

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }
    
    
}
