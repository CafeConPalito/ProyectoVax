/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.serverzipdownload;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CafeConPalito
 */
public class HiloZip implements Runnable{
    
    Socket cliente;

    public HiloZip(Socket cliente) {
        this.cliente = cliente;
    }

    @Override
    public void run() {
        
        //Inicializo los buffer de entrada y salida de datos
        BufferedInputStream bis = null;
        DataInputStream bufferDatosEntrada = null;
        DataOutputStream bufferDatosSalida = null;
        try {

            //Metodo de espera para cerrar la conexion por si existe alguna perdida de paquetes en el envio, espera 10 seg
            this.cliente.setSoLinger(true, 10);

            //se declaran los gru`pos de comunicacion con el cliente
            //flujo de entrada o lectura
            bufferDatosEntrada = new DataInputStream(cliente.getInputStream());

            //flujo de salida o escritura
            bufferDatosSalida = new DataOutputStream(cliente.getOutputStream());

            //--------- Trabajo interno.
            //Enviar DATOS al Cliente.
            
            //RECIBO EL NOMBRE DEL ARCHIVO
            String nombreArchivo = bufferDatosEntrada.readUTF();
            
            File archivoEnviar = new File("zip" + File.separator +nombreArchivo); //Imagen a enviar al cliente
            bis = new BufferedInputStream(new FileInputStream(archivoEnviar));
            //---------

            //Creo una Buffer para leer el archivo con un tamaño de 1024 bytes
            byte[] bufferSalida = new byte[1024];
            
            //Leo el archivo a enviar y almaceno el valor de Bytes leidos
            int numBytesLeidos = 0;
            numBytesLeidos = bis.read(bufferSalida);

            //Mientras el numero de Bytes sea distito de -1 enviara datos al cliente
            while (numBytesLeidos != -1) {
                // 2 * envio el paquete de datos.
                bufferDatosSalida.write(bufferSalida, 0, numBytesLeidos);
                //Leo el archivo y lo almaceno en el buffer
                numBytesLeidos = bis.read(bufferSalida);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(HiloZip.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //Cierro las conexiones
            try {
                if (bis != null) {
                    bis.close();
                }
                if (bufferDatosEntrada != null) {
                    bufferDatosEntrada.close();
                }
                if (bufferDatosSalida != null) {
                    bufferDatosSalida.close();
                }
                cliente.close();
            } catch (IOException ex) {
                Logger.getLogger(HiloZip.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    
    }
    
    
    
}
