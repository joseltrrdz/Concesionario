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
public class HiloManejadorCliente implements Runnable{
    private Thread hilo;
    private Socket s;
    private Concesionario c1;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;

    public Thread getHilo() {
        return hilo;
    }

    public void setHilo(Thread hilo) {
        this.hilo = hilo;
    }

    public Socket getS() {
        return s;
    }

    public void setS(Socket s) {
        this.s = s;
    }

    public Concesionario getC1() {
        return c1;
    }

    public void setCb1(Concesionario c1) {
        this.c1 = c1;
    }

    public ObjectInputStream getOis() {
        return ois;
    }

    public void setOis(ObjectInputStream ois) {
        this.ois = ois;
    }

    public ObjectOutputStream getOos() {
        return oos;
    }

    public void setOos(ObjectOutputStream oos) {
        this.oos = oos;
    }
    
    
    public HiloManejadorCliente(Concesionario c1, Socket s) {
        this.hilo = new Thread(this);
        this.s = s;
        this.c1 = c1;
        
        //Preparar los streams de entrada y de salida del Socket
        try {
            OutputStream os = this.s.getOutputStream();
            oos = new ObjectOutputStream(os);
            InputStream is = this.s.getInputStream();
            ois = new ObjectInputStream(is);
        } catch (IOException ex) {
            Logger.getLogger(HiloManejadorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void run() {
        try {
        Usuario usuarioCorrecto = null;
        String respuesta = null;
        boolean correcto = false;
        while (usuarioCorrecto == null) {
            EnvioLogueo el1 = (EnvioLogueo) this.ois.readObject();
            usuarioCorrecto = this.c1.comprobarUsuario(el1.getUsuario(), el1.getClave());
            if (usuarioCorrecto != null) {
                respuesta = "Te has logueado correctamente";
                correcto = true;
            } else {
                respuesta = "Lo siento no eres un usuario";
                correcto = false;
            }
            EnvioRespuestaLogueo erl1 = new EnvioRespuestaLogueo(respuesta, correcto, usuarioCorrecto);
            oos.writeObject(erl1);
            oos.flush();
        }

        while (true) {
            EnvioRed er1 = new EnvioRed(this.c1.getCoches());
            oos.writeObject(er1);
            oos.flush();
            
            RespuestaRed rr1 = (RespuestaRed) this.ois.readObject();
            String modelo = rr1.getModelo();
            if (rr1.isAceptar()) {
                this.c1.comprar(modelo);
                System.out.println("Modelo comprado: " + modelo);

                // Después de comprar, envía la lista actualizada de coches al cliente
                EnvioRed erActualizado = new EnvioRed(this.c1.getCoches());
                oos.writeObject(erActualizado);
                oos.flush();
            }
        }
    } catch (IOException | ClassNotFoundException ex) {
        Logger.getLogger(HiloManejadorCliente.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
}
