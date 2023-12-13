/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.socket;

import java.io.BufferedInputStream;
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
    private static final int PUERTO = 6666;

    private String gameName;

    public SocketZipGameDownload(String gameName) {
        this.gameName = gameName;
        run();
    }

    @Override
    public void run() {
        /*
        BufferedInputStream bis = null;
        DataInputStream bufferDatosEntrada = null;
        DataOutputStream bufferDatosSalida = null;
        try{

            // 1!!!!! PREGUNTAR SI EL ARCHIVO EXISTE
            bufferDatosSalida.writeUTF(gameName+".zip");
            
            // 1* RECIBIR NOMBRE ARCHIVO
            String nombreArchivo = bufferDatosEntrada.readUTF(); // recibo en nombre del archivo
            //Creo el Buffer de escritura para almacenar el archivo recibido en disco con el nombre que recibimos.
            bos = new BufferedOutputStream(new FileOutputStream(ServerZipUpload.dirName+"/"+nombreArchivo)); // pongo el nombre.
            
            byte[] bufferEntrada= new byte[1024];

            int numBytesLeidos = bufferDatosEntrada.read(bufferEntrada);
            
            while (numBytesLeidos != -1) {
                
                bos.write(bufferEntrada, 0, numBytesLeidos);
                // 2 * recibo el paquete de datos
                numBytesLeidos=bufferDatosEntrada.read(bufferEntrada);
                
            }

        } catch (IOException ex) {
            Logger.getLogger(HiloZip.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                if (bos != null) {
                    bos.close();
                }                
                cliente.close();
            } catch (IOException ex) {
                Logger.getLogger(HiloZip.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    
    }
*/        
    }

}
