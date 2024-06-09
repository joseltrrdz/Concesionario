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
class Coche implements Serializable{
    private String modelo;
    private String color;
    private double precio;
    private boolean enVenta;
    
    public Coche(String modelo, String color, double precio) {
        this.modelo = modelo;
        this.color = color;
        this.precio = precio;
        this.enVenta=true;
    }

    public synchronized String getModelo() {
        return modelo;
    }

    public synchronized void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public synchronized String getColor() {
        return color;
    }

    public synchronized void setColor(String color) {
        this.color = color;
    }

    public synchronized double getPrecio() {
        return precio;
    }

    public synchronized void setPrecio(double precio) {
        this.precio = precio;
    }

    public synchronized boolean isEnVenta() {
        return enVenta;
    }

    public synchronized void setEnVenta(boolean enVenta) {
        this.enVenta = enVenta;
    }
    
    
}
