

package com.cafeconpalito.clientimagen;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ramiro
 */
public class ClientImagen {

    public static void main(String[] args) {
        String direccion;
        Socket servidor;
        final int PUERTO = 6666;

        System.out.println("soy el cliente e intento conectarme");

        direccion = "192.168.34.4";
        try {
            //nos conectamos al servidor:direccion y puerto
            servidor = new Socket(direccion, PUERTO);
            System.out.println("conexion realizada con exito");

            DataInputStream bufferDatosEntrada = new DataInputStream(servidor.getInputStream());
            DataOutputStream bufferDatosSalida = new DataOutputStream(servidor.getOutputStream());
            
            String mensaje = bufferDatosEntrada.readUTF();
            System.out.println(mensaje);
            
            bufferDatosEntrada.close();
            bufferDatosSalida.close();
            servidor.close();
            
            System.out.println("soy el cliente y cierro la conexion");

        } catch (IOException ex) {
            Logger.getLogger(ClientImagen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
