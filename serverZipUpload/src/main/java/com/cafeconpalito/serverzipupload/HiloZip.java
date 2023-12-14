/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.serverzipupload;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damt210
 */
public class HiloZip implements Runnable {

    Socket cliente;

    public HiloZip(Socket cliente) {
        this.cliente = cliente;
    }

    @Override
    public void run() {
    
        BufferedOutputStream bos = null;
        try(
                DataInputStream bufferDatosEntrada = new DataInputStream(cliente.getInputStream());
                DataOutputStream bufferDatosSalida = new DataOutputStream(cliente.getOutputStream());
                ){

            // 1* RECIBIR NOMBRE ARCHIVO
            String nombreArchivo = bufferDatosEntrada.readUTF(); // recibo en nombre del archivo
            //Creo el Buffer de escritura para almacenar el archivo recibido en disco con el nombre que recibimos.
            bos = new BufferedOutputStream(new FileOutputStream(ServerZipUpload.dirName+ File.separator +nombreArchivo)); // pongo el nombre.
            
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
    
    
    
 

}
