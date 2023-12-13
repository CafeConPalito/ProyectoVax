/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.socket;

import com.cafeconpalito.proyectovax.EntryPoint;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damt207
 */
public class SocketZipGameDownload implements Runnable {

    private Socket servidor;
    private static final int PUERTO = 6663;

    private String gameName;
    private String dirGames = "games";

    public SocketZipGameDownload(String gameName) {
        this.gameName = gameName;
        run();
    }

    @Override
    public void run() {
        
        //Creo la carpeta Games si no existe
        File f = new File(dirGames);
        if (!f.isDirectory()) {
            f.mkdir();
        }
        
        //Ruta de la carpeta para el juego
        String dirGamesGame = dirGames +"/"+gameName;
        
        //Creo la carpeta del juego para almacenarlo
        File fg = new File(dirGamesGame);
        if (!fg.isDirectory()) {
            fg.mkdir();
        }
        
        BufferedOutputStream bos = null;
        DataInputStream bufferDatosEntrada = null;
        DataOutputStream bufferDatosSalida = null;
        try{
                    
            servidor = new Socket(EntryPoint.serverIP, PUERTO);
            
            this.servidor.setSoLinger(true, 10);
            
            bufferDatosEntrada = new DataInputStream(servidor.getInputStream());
            bufferDatosSalida = new DataOutputStream(servidor.getOutputStream());
            
            // ENVIAR AL SERVER EL NOMBRE DEL JUEGO A DESCARGAR
            String nombreArchivo = gameName+".zip";
            bufferDatosSalida.writeUTF(nombreArchivo);

            if (bufferDatosEntrada.readBoolean()) {
                
            }
            
            bos = new BufferedOutputStream(new FileOutputStream(dirGamesGame+"/"+nombreArchivo)); // pongo el nombre.
            
            byte[] bufferEntrada= new byte[1024];

            int numBytesLeidos = bufferDatosEntrada.read(bufferEntrada);
            
            while (numBytesLeidos != -1) {
                
                bos.write(bufferEntrada, 0, numBytesLeidos);
                // 2 * recibo el paquete de datos
                numBytesLeidos=bufferDatosEntrada.read(bufferEntrada);
                
            }

        } catch (IOException ex) {
            Logger.getLogger(SocketZipGameDownload.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                if (bos != null) {
                    bos.close();
                }                
                if (bufferDatosEntrada != null) {
                    bufferDatosEntrada.close();
                }
                if (bufferDatosSalida != null) {
                    bufferDatosSalida.close();
                }
                servidor.close();
            } catch (IOException ex) {
                Logger.getLogger(SocketZipGameDownload.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    
    }
    
    

}
