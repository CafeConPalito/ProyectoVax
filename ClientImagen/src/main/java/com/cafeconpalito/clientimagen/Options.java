/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.clientimagen;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ramiro
 */
public class Options {

    static String direccion = "localhost";
    static Socket servidor;
    static final int PUERTO = 6666;

    public static void uploadImg() {

        try {
            servidor = new Socket(direccion, PUERTO);
            System.out.println("conexion realizada con exito");

            DataInputStream bufferDatosEntrada = new DataInputStream(servidor.getInputStream());
            DataOutputStream bufferDatosSalida = new DataOutputStream(servidor.getOutputStream());

            //1 Envío lo que quiero
            String opcion = "carga";
            bufferDatosSalida.writeUTF(opcion);

            // 2 Espero la respuesta
            //--------- Trabajo interno.
            //Enviar DATOS al Servidor.
            File archivoEnviar = new File("AD3 Modelo ORM - Hibernate.pdf"); //Imagen a enviar al cliente 

            //Envio el nombre al servidor
            bufferDatosSalida.writeUTF(archivoEnviar.getName());
            //Enviar tamaño del archivo

            //Se necesita un Array de Bytes para almacenar la informacion con el tamaño del archivo.
            byte[] arrayDeBitesArchivo = new byte[(int) archivoEnviar.length()];
            //Creo un Buffer para leer el archivo

            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(archivoEnviar));
            //Leo con el buffer el archivo ya lo tengo en memoria.

            bis.read(arrayDeBitesArchivo, 0, arrayDeBitesArchivo.length);

            //---------
            //--------- El servidor escucha.
            //Envieando la info de 1024 en 1024 Bytes.
            System.out.println("Opcion del cliente: " + opcion);
            int offset = 0; // Permite identificar la posicion desde la que se va a empezar a enviar en cada pasada.
            while (offset < arrayDeBitesArchivo.length) {
                int length = Math.min(arrayDeBitesArchivo.length - offset, 1024); // Tamaño de los Paquetes que se quiere enviar en este caso 1024 Bytes
                bufferDatosSalida.write(arrayDeBitesArchivo, offset, length);
                offset += length;
                System.out.println("enviando datos: " + length);
            }
            System.out.println("informacion envida al cliente");

            // 3 Cierro los búferes y servidor
            bis.close();
            bufferDatosEntrada.close();
            bufferDatosSalida.close();
            servidor.close();

            System.out.println("Archivo enviado. Conexión cerrada");

        } catch (IOException ex) {
            Logger.getLogger(Options.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void downloadImg() {
        try {

            File archivoDescargado;

            servidor = new Socket(direccion, PUERTO);
            System.out.println("conexion realizada con exito");

            DataInputStream bufferDatosEntrada = new DataInputStream(servidor.getInputStream());
            DataOutputStream bufferDatosSalida = new DataOutputStream(servidor.getOutputStream());

            //1 Envío lo que quiero
            String opcion = "descarga";
            bufferDatosSalida.writeUTF(opcion);

            
            // 1* RECIBIR NOMBRE ARCHIVO
            String nombreArchivo = bufferDatosEntrada.readUTF(); // recibo en nombre del archivo
            //Creo el Buffer de escritura para almacenar el archivo recibido en disco con el nombre que recibimos.
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(nombreArchivo)); // pongo el nombre.
            System.out.println("nombre archivo " + nombreArchivo );
        
            //mientras este recibiendo informacion seguira escibiendo
            
            
            byte[] bufferEntrada= new byte[1024];

            int numBytesLeidos = bufferDatosEntrada.read(bufferEntrada);
            //Mientras el offset de escritura sea menor que el tamaño del archivo escribirar.
            while (numBytesLeidos != -1) {
                
                bos.write(bufferEntrada, 0, numBytesLeidos);
                
                // 2 * recibo el paquete de datos
                numBytesLeidos=bufferDatosEntrada.read(bufferEntrada);
                
                //leo el buffer recibido y escribo la escribo la informacion
                
                
            }

            // 3 Cierro los búferes y servidor
            System.out.println("Archivo recibido y conexión cerrada");

            //Cierro bos
            bos.close();

            // 3 Cierro los búferes y servidor
            bos.close();
            bufferDatosEntrada.close();
            bufferDatosSalida.close();
            servidor.close();

            System.out.println("Archivo recibido y conexión cerrada");

        } catch (IOException ex) {
            Logger.getLogger(Options.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }

    }
}
