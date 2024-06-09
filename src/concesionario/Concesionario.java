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
public class Concesionario{
    ArrayList<Usuario> usuarios;
    ArrayList<Coche> coches;

    public synchronized ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public synchronized void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public synchronized ArrayList<Coche> getCoches() {
        return coches;
    }

    public synchronized void setCoches(ArrayList<Coche> coches) {
        this.coches = coches;
    }
    
    
    public Concesionario() {
        this.usuarios = new ArrayList<Usuario>();
        this.coches = new ArrayList<Coche>();
        Usuario usuario1 = new Usuario("email1","clave1");
        Usuario usuario2 = new Usuario("email2","clave2");
        Usuario usuario3 = new Usuario("email3","clave3");
        
        ArrayList<Coche> coches1 = new ArrayList<Coche>();
        coches.add(new Coche("Ford Focus","Rojo",80));
        coches.add(new Coche("Fiat 500","Blanco",30));
        //usuario1.setCoches(coches1);
        
        ArrayList<Coche> coches2 = new ArrayList<Coche>();
        coches.add(new Coche("Audi A5","Negro",90));
        coches.add(new Coche("Nissan Micra","Gris",40));
        //usuario2.setCoches(coches2);
        
        ArrayList<Coche> coches3 = new ArrayList<Coche>();
        coches.add(new Coche("Seat Leon","Negro",50));
        coches.add(new Coche("Opel Corsa","Blanco",20));
        //usuario3.setCoches(coches3);
        this.usuarios.add(usuario1);
        this.usuarios.add(usuario2);
        this.usuarios.add(usuario3);
    }
        
    public synchronized Usuario comprobarUsuario(String usuario, String clave) {
        Usuario existe = null;
        for(Usuario xusuario : this.usuarios){
            if(xusuario.getUsuario().equals(usuario)){
                if(xusuario.getClave().equals(clave)){
                    existe = xusuario;
                }
            }
        }
        return existe;
    }
    
    public synchronized void ponerEnVenta(Usuario usuario,String modelo){
        for(Coche cochecito: usuario.getCoches()){
            if(cochecito.getModelo().equals(modelo)){
                cochecito.setEnVenta(true);
            }
        }
    }

    public synchronized void comprar(String modelo) {
    for (Coche cochecito : this.coches) {
        if (cochecito.getModelo().equals(modelo)) {
            cochecito.setEnVenta(false);
            System.out.println("Coche comprado: " + modelo);
        }
    }
}
}
