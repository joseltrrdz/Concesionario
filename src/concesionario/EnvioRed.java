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
class EnvioRed implements Serializable{
    private ArrayList<Coche> coches;
    
    public EnvioRed(ArrayList<Coche> coches) {
        this.coches = coches;
    }

    public ArrayList<Coche> getCoches() {
        return coches;
    }

    public void setCoches(ArrayList<Coche> coches) {
        this.coches = coches;
    }


    
    
    
}
