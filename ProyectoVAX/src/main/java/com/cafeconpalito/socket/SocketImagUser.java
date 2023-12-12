/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.socket;

import com.cafeconpalito.proyectovax.EntryPoint;
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
public class SocketImagUser implements Runnable {

    private Socket servidor;
    private static final int PUERTO = 6666;

    private String userAlias;
    private String imagenPath;
    private String imagenExtencion;

    public SocketImagUser(String userAlias, String imagenPath, String imagenExtencion) {
        this.userAlias = userAlias;
        this.imagenPath = imagenPath;
        this.imagenExtencion = imagenExtencion;
    }

    @Override
    public void run() {

        BufferedInputStream bis = null;
        DataInputStream bufferDatosEntrada = null;
        DataOutputStream bufferDatosSalida = null;
        try {
            
            servidor = new Socket(EntryPoint.serverIP, PUERTO);
            
            this.servidor.setSoLinger(true, 10);

            //se declaran los gru`pos de comunicacion con el cliente
            //flujo de entrada o lectura
            bufferDatosEntrada = new DataInputStream(servidor.getInputStream());

            //flujo de salida o escritura
            bufferDatosSalida = new DataOutputStream(servidor.getOutputStream());

            //--------- Trabajo interno.
            //Enviar DATOS al Cliente.
            File archivoEnviar = new File(imagenPath); //Imagen a enviar al cliente
            bis = new BufferedInputStream(new FileInputStream(archivoEnviar));
            //---------

            //--------- CLiente tiene que escuchar
            // 1* ENVIO NOMBRE ARCHIVO
            bufferDatosSalida.writeUTF(userAlias + imagenExtencion); // El nombre con el que se guardara sera el Alias del usuario con la extencion

            //Creo una Buffer para leer el archivo
            //mientras el offset sea menor que el tamaño del archivo enviara datos
            byte[] bufferSalida = new byte[1024];
            int numBytesLeidos = 0;

            numBytesLeidos = bis.read(bufferSalida);

            while (numBytesLeidos != -1) {
                // 2 * envio el paquete de datos.
                bufferDatosSalida.write(bufferSalida, 0, numBytesLeidos);
                //Leo el archivo y lo almaceno en el buffer
                numBytesLeidos = bis.read(bufferSalida);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(SocketImagUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
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
                Logger.getLogger(SocketImagUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
