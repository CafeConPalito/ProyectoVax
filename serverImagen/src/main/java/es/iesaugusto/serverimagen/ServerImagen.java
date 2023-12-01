package es.iesaugusto.serverimagen;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerImagen {

    public static void main(String[] args) {
        
        
        ServerSocket servidor;//escucha del servidor
        final int PUERTO=6666;//puerto de escucha (a partir del 1024)
        
        Socket cliente; // atencion a cliente
        int numCliente=0;// contador clientes
        
        System.out.println("Soy el servidor, y empiezo a escuchar peticiones por el puerto "+ PUERTO);
        
        try {
            //apertura de socket para escuchar a través de un puerto
            servidor = new ServerSocket(PUERTO);
            
            do {
                
                numCliente ++;
                
                cliente=servidor.accept(); //aceptamos la conexión de un cliente
                
                System.out.println("Cliente Conectado" + numCliente); //
                
                HiloImagen h = new HiloImagen(cliente); // creamos un hilo de cliente
                
                Thread t = new Thread(h);
                
                t.start(); //lanzamos el hilo
                System.out.println("Hilo Lanzado");
                
            } while (true);
            
            
        } catch (IOException ex) {
            Logger.getLogger(ServerImagen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
