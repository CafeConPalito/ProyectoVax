/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.iesaugusto.serverimagen;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damt210
 */
public class HiloImagen implements Runnable {

    Socket cliente;

    public HiloImagen(Socket cliente) {
        this.cliente = cliente;
    }

    @Override
    public void run() {

        try {
            
            this.cliente.setSoLinger(true, 10);

            //se declaran los gru`pos de comunicacion con el cliente
            //flujo de entrada o lectura
            DataInputStream bufferDatosEntrada = new DataInputStream(cliente.getInputStream());

            //flujo de salida o escritura
            DataOutputStream bufferDatosSalida = new DataOutputStream(cliente.getOutputStream());

            //A partir de aquí se establece el protocolo de comunicacion
            System.out.println("Esperando Opcion del cliente");

            //1
            String opcion = bufferDatosEntrada.readUTF();

            switch (opcion) { //Opcion del Cliente
                case "descarga":// ENVIANDO PAQUETE DE INFORMACION AL CLIENTE
                    
                    System.out.println("Entro en Descarga");
                    //--------- Trabajo interno.
                    //Enviar DATOS al Cliente.
                    File archivoEnviar = new File("logo-negative.png"); //Imagen a enviar al cliente 
                    BufferedInputStream bis = new BufferedInputStream(new FileInputStream(archivoEnviar));
                    //---------
                    
                    //--------- CLiente tiene que escuchar
                    // 1* ENVIO NOMBRE ARCHIVO
                    bufferDatosSalida.writeUTF(archivoEnviar.getName());
                    
                    System.out.println("Opcion del cliente: " + opcion);

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

                    System.out.println("informacion envida al cliente");

                    //Cierro bis
                    bis.close();

                    break;
                case "carga":
                    
                    
                    // 1* RECIBIR NOMBRE ARCHIVO
                    String nombreArchivo = bufferDatosEntrada.readUTF(); // recibo en nombre del archivo
                    //Creo el Buffer de escritura para almacenar el archivo recibido en disco con el nombre que recibimos.
                    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(nombreArchivo)); // pongo el nombre.

                    // 2* RECIBIR TAMAÑO DEL ARCHIVO
                    long lengthFile = bufferDatosEntrada.readLong();
                    
                    //mientras este recibiendo informacion seguira escibiendo
                    int offsetRecib = 0;
                    
                    //Mientras el offset de escritura sea menor que el tamaño del archivo escribirar.
                    while (offsetRecib < lengthFile ) {
                        
                        // Capturo el tamaño del paquete a recibir
                        int length = bufferDatosEntrada.available();
                        System.out.println("Tamaño del paq a recibir" + length);
                        // Creo un array del tamaño del paquete a recibir
                        byte[] buffer = new byte[length];

                        //Escribo en el buffer el paquete recibido
                        buffer = bufferDatosEntrada.readAllBytes();
                        bos.write(buffer, offsetRecib, length);
                        
                        offsetRecib += length;
                    }

                    // 3 Cierro los búferes y servidor
                    System.out.println("Archivo recibido y conexión cerrada");

                    //Cierro bos
                    bos.close();

                    break;
                default:

                    throw new AssertionError();
            }

            //3 Cerra Buffers y Server
            //bufferDatosSalida.writeUTF("usted es mi cliente:");
            bufferDatosEntrada.close();
            bufferDatosSalida.close();
            cliente.close();
            System.out.println("comunicacion con el cliente cerrada");

        } catch (IOException ex) {
            Logger.getLogger(HiloImagen.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
