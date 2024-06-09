/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package concesionario;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jose-
 */
public class Cliente {
    
    public static void main(String[]args){
        int puerto = 6010;
        String direccion = "localhost";  
        Socket s;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;     
        OutputStream os;
        boolean correcto = false;
        try {
            s = new Socket(direccion,puerto);
            os = s.getOutputStream();
            oos = new ObjectOutputStream(os);
            InputStream is = s.getInputStream();
            ois = new ObjectInputStream(is);
            ConexionFrame ventana1 = new ConexionFrame();
            ventana1.setVisible(true);
            EnvioRespuestaLogueo erl1 = null;
            while(!correcto){
                EnvioLogueo el1 = new EnvioLogueo(ventana1.usuario,ventana1.clave);
                oos.writeObject(el1);
                oos.flush();
                //Respuesta del servidor
                erl1 = (EnvioRespuestaLogueo) ois.readObject();
                correcto = erl1.isCorrecto();
            }
            if(correcto){
                ClienteFrame ventana2 = new ClienteFrame();
                ventana2.setVisible(true);
                ventana1.dispose();
                ventana2.ois=ois;
                ventana2.oos=oos;
            }
            
        } catch (IOException ex) {
            Logger.getLogger(ClienteFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
