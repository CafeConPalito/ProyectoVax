/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.socket;

import com.cafeconpalito.proyectovax.EntryPoint;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Collections;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.*;

/**
 *
 * @author CafeConPalito
 */
public class SocketZipGameDownload implements Runnable {

    private Socket servidor;
    private static final int PUERTO = 6663;

    private String gameName;
    private String dirGames = "games";

    
    /**
     * metodo que descarga un juego desde el servidor
     * @param gameName nombre del juego que se quiere descargar, rescatado de la BBDD
     */
    public SocketZipGameDownload(String gameName) {
        this.gameName = gameName;
        run();
    }

    /**
     * Lanza la descarga del archivo .zip al servidor
     * descomprime el archivo
     * borra el archivo .zip descargado
     */
    @Override
    public void run() {
        
        //Declaro a nulo la   
        String zipFilePath = null;

        //Creo la carpeta Games si no existe
        File f = new File(dirGames);
        if (!f.isDirectory()) {
            f.mkdir();
        }

        //Ruta de la carpeta para el juego
        String dirGamesGame = dirGames + File.separator + gameName;

        //Creo la carpeta del juego para almacenarlo
        File fg = new File(dirGamesGame);
        if (!fg.isDirectory()) {
            fg.mkdir();
        }

        BufferedOutputStream bos = null;
        DataInputStream bufferDatosEntrada = null;
        DataOutputStream bufferDatosSalida = null;
        try {

            servidor = new Socket(EntryPoint.serverIP, PUERTO);

            this.servidor.setSoLinger(true, 10);

            bufferDatosEntrada = new DataInputStream(servidor.getInputStream());
            bufferDatosSalida = new DataOutputStream(servidor.getOutputStream());

            // ENVIAR AL SERVER EL NOMBRE DEL JUEGO A DESCARGAR
            String nombreArchivo = gameName + ".zip";
            bufferDatosSalida.writeUTF(nombreArchivo);
            
            //guardo el pathDonde llegara el zip
            zipFilePath = dirGamesGame + File.separator + nombreArchivo;
            
            //Creo un buffer para escribir el juego que recibe el cliente
            bos = new BufferedOutputStream(new FileOutputStream(zipFilePath)); 
            
            //Creo una Buffer para leer el archivo con un tamaño de 1024 bytes
            byte[] bufferEntrada = new byte[1024];

            //Leo los datos enviados por el servidor los almaceno en el buffer y almaceno el valor los Bytes leidos
            int numBytesLeidos = bufferDatosEntrada.read(bufferEntrada);

            //Mientras el numero de Bytes sea distito de -1 recibira datos al servidor
            while (numBytesLeidos != -1) {

                bos.write(bufferEntrada, 0, numBytesLeidos);
                // 2 * recibo el paquete de datos
                numBytesLeidos = bufferDatosEntrada.read(bufferEntrada);

            }

        } catch (IOException ex) {
            Logger.getLogger(SocketZipGameDownload.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //Cierro las conexiones
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
        
        //al terminar la descarga descomprimo el ZIP
        descomprimirZip(zipFilePath, dirGamesGame);
        //borro el zip al terminar la descomprecion
        borrarZip(zipFilePath);
        
    }

    /**
     * Metodo que borra un zip al terminar la descarga
     * @param zipFilePath 
     */
    private void  borrarZip(String zipFilePath){
        File f = new File(zipFilePath);
        if (f.exists()) {
            f.delete();
        }
    }
    
    
    /**
     * Metodo para leer un fichero Zip y descomprimir la informacion
     * @param zipFilePath recibe como parametro la ruta del zip
     * @param directorioDestino directorio donde se desea descomprimir
     */
    private void descomprimirZip(String zipFilePath, String directorioDestino) {
        byte[] buffer = new byte[1024];
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFilePath))) {
            // Recorrer cada entrada en el archivo ZIP
            ZipEntry ze = zis.getNextEntry();
            while (ze != null) {
                String nombreArchivo = ze.getName();
                File nuevoArchivo = new File(directorioDestino + File.separator + nombreArchivo);
                // Si la entrada es un directorio, crearlo
                if (ze.isDirectory()) {
                    nuevoArchivo.mkdirs();
                } else {
                    // Si la entrada es un archivo, asegurarse de que el directorio padre exista
                    File directorioPadre = nuevoArchivo.getParentFile();
                    if (!directorioPadre.exists()) {
                        directorioPadre.mkdirs();
                    }
                    // Escribir el archivo
                    try (FileOutputStream fos = new FileOutputStream(nuevoArchivo)) {
                        int len;
                        while ((len = zis.read(buffer)) > 0) {
                            fos.write(buffer, 0, len);
                        }
                    }
                }
                // Cerrar la entrada actual y avanzar a la siguiente
                zis.closeEntry();
                ze = zis.getNextEntry();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(SocketZipGameDownload.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
