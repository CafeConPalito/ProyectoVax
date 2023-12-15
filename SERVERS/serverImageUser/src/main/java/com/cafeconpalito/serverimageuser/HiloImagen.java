/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.serverimageuser;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CafeConPalito
 */
public class HiloImagen implements Runnable {

    Socket cliente;

    public HiloImagen(Socket cliente) {
        this.cliente = cliente;
    }

    @Override
    public void run() {
    
        //Inicializo los buffer de entrada y salida de datos
        BufferedOutputStream bos = null;
        try(
                DataInputStream bufferDatosEntrada = new DataInputStream(cliente.getInputStream());
                DataOutputStream bufferDatosSalida = new DataOutputStream(cliente.getOutputStream());
                ){
            
             //Metodo de espera para cerrar la conexion por si existe alguna perdida de paquetes en el envio, espera 10 seg
            this.cliente.setSoLinger(true, 10);

            // 1* RECIBIR NOMBRE ARCHIVO
            String nombreArchivo = bufferDatosEntrada.readUTF(); // recibo en nombre del archivo
            //Creo el Buffer de escritura para almacenar el archivo recibido en disco con el nombre que recibimos.
            bos = new BufferedOutputStream(new FileOutputStream(ServerImageUser.dirName + File.separator + nombreArchivo)); // pongo el nombre.
            
            //Creo una Buffer para leer el archivo con un tamaño de 1024 bytes
            byte[] bufferEntrada= new byte[1024];

            //Leo los datos del archivo a recibir, los almaceno en el buffer y almaceno el valor de Bytes leidos
            int numBytesLeidos = bufferDatosEntrada.read(bufferEntrada);
            
            //Mientras el numero de Bytes sea distito de -1 recibo datos al cliente
            while (numBytesLeidos != -1) {
                
                bos.write(bufferEntrada, 0, numBytesLeidos);
                // 2 * recibo el paquete de datos
                numBytesLeidos=bufferDatosEntrada.read(bufferEntrada);
                
            }

        } catch (IOException ex) {
            Logger.getLogger(HiloImagen.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            //Cierro las conexiones
            try {
                if (bos != null) {
                    bos.close();
                }                
                cliente.close();
            } catch (IOException ex) {
                Logger.getLogger(HiloImagen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    
    }
    
    
    
 

}
