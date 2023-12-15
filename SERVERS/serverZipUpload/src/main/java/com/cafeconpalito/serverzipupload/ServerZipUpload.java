/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.cafeconpalito.serverzipupload;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CafeConPalito
 */
public class ServerZipUpload {

   public static String dirName = "zip";

    public static void main(String[] args) {

        ServerSocket servidor;//escucha del servidor
        final int PUERTO = 6664;//puerto de escucha (a partir del 1024)

        Socket cliente; // atencion a cliente
        
        File f = new File(dirName);
        if (!f.isDirectory()) {
            f.mkdir();
        }

        System.out.println("Server Escuchando");

        try {
            //apertura de socket para escuchar a través de un puerto
            servidor = new ServerSocket(PUERTO);

            do {
                cliente = servidor.accept(); //aceptamos la conexión de un cliente

                HiloZip h = new HiloZip(cliente); // creamos un hilo de cliente

                Thread t = new Thread(h);

                t.start(); //lanzamos el hilo

            } while (true);

        } catch (IOException ex) {
           Logger.getLogger(ServerZipUpload.class.getName()).log(Level.SEVERE, null, ex);
       }

    }
}
