/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package concesionario;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jose-
 */
public class Servidor {
    public static void main(String[]args){
        int puertoEscucha = 6010;
        ServerSocket ss;
        Concesionario c1 = new Concesionario();
        try{
            ss = new ServerSocket(puertoEscucha);
            while(true){
                Socket s = ss.accept();
                System.out.println("Se ha conectado el cliente "+s.getInetAddress());
                HiloManejadorCliente hmc1 = new HiloManejadorCliente(c1,s);
                hmc1.getHilo().start();
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
