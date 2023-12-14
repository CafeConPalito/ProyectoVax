/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.socket;

import com.cafeconpalito.proyectovax.EntryPoint;
import com.google.common.io.Files;
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
 * @author damt207
 */
public class SocketZipGameUpload implements Runnable{
    
    private Socket servidor;
    private static final int PUERTO = 6664;

    private String gameName;
    private String zipAbsolutePath;
    private String zipExtencion;
    
    /**
     * Constructor con parametros que lanza directamente el hilo para subir el ZIP
     * @param gameName nombre del juego que se utiliza en el registro, se utiliza para renombrar el ZIP
     * @param zipAbsolutePath ruta absoluta donde se encuentra el ZIP
     */
    public SocketZipGameUpload(String gameName, String zipAbsolutePath) {
        this.gameName = gameName;
        this.zipAbsolutePath = zipAbsolutePath;
        this.zipExtencion = "."+Files.getFileExtension(this.zipAbsolutePath);
        run();
    }

    @Override
    public void run() {
        
        //Inicializo las conexiones necesarias a nulo
        BufferedInputStream bis = null;
        DataInputStream bufferDatosEntrada = null;
        DataOutputStream bufferDatosSalida = null;
        try {
            
            //Establesco la conexion con el servidor
            servidor = new Socket(EntryPoint.serverIP, PUERTO);
            
            //Metodo de espera para cerrar la conexion por si existe alguna perdida de paquetes en el envio, espera 10 seg
            this.servidor.setSoLinger(true, 10);

            //se declaran los gru`pos de comunicacion con el cliente
            //flujo de entrada o lectura
            bufferDatosEntrada = new DataInputStream(servidor.getInputStream());
            bufferDatosSalida = new DataOutputStream(servidor.getOutputStream());

            //Bufer de lectura del archivo a enviar
            bis = new BufferedInputStream(new FileInputStream(new File(zipAbsolutePath)));

            //--------- CLiente tiene que escuchar
            // 1* ENVIO NOMBRE ARCHIVO
            bufferDatosSalida.writeUTF(gameName + zipExtencion); // El nombre con el que se guardara sera el juego con la extencion

            //Creo una Buffer para leer el archivo con un tamaño de 1024 bytes
            byte[] bufferSalida = new byte[1024];
            
            //Leo el archivo a enviar y almaceno el valor de Bytes leidos
            int numBytesLeidos = 0;
            numBytesLeidos = bis.read(bufferSalida);

            //Mientras el numero de Bytes sea distito de -1 enviara datos al servidor
            while (numBytesLeidos != -1) {
                // 2 * envio el paquete de datos.
                bufferDatosSalida.write(bufferSalida, 0, numBytesLeidos);
                //Leo el archivo y lo almaceno en el buffer
                numBytesLeidos = bis.read(bufferSalida);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(SocketZipGameUpload.class.getName()).log(Level.SEVERE, null, ex);
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
            } catch (IOException ex) {
                Logger.getLogger(SocketZipGameUpload.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
    
    }
    
}
