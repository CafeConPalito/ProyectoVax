package es.iesaugusto.serverimagen;

import java.io.File;
import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerImagenUser {

    public static String dirName= "imguser";
    
    public static void main(String[] args) {
        
        
        ServerSocket servidor;//escucha del servidor
        final int PUERTO=6666;//puerto de escucha (a partir del 1024)
        
        Socket cliente; // atencion a cliente
        int numCliente=0;// contador clientes
        
        
        File f = new File(dirName);
        if (!f.isDirectory()) {
            f.mkdir();
        }
        
        System.out.println("Server Escuchando");
        
        try {
            //apertura de socket para escuchar a través de un puerto
            servidor = new ServerSocket(PUERTO);
            
            do {
                cliente=servidor.accept(); //aceptamos la conexión de un cliente

                HiloImagen h = new HiloImagen(cliente); // creamos un hilo de cliente
                
                Thread t = new Thread(h);
                
                t.start(); //lanzamos el hilo
               
            } while (true);
            
            
        } catch (IOException ex) {
            Logger.getLogger(ServerImagenUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
