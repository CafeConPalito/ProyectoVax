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
                case "descarga":

                    //--------- Trabajo interno.
                    //Enviar DATOS al Cliente.
                    File archivoEnviar = new File("logo-negative.png"); //Imagen a enviar al cliente 
                    BufferedInputStream bis = new BufferedInputStream(new FileInputStream(archivoEnviar));
                    //---------
                    
                    //--------- CLiente tiene que escuchar
                    //ENVIO NOMBRE ARCHIVO
                    bufferDatosSalida.writeUTF(archivoEnviar.getName());

                    System.out.println("Opcion del cliente: " + opcion);

                    //Creo una Buffer para leer el archivo
                    int offset = 0; // Permite identificar la posicion desde la que se va a empezar a enviar en cada pasada.
                    //mientras el offset sea menor que el tamaño del archivo enviara datos
                    while (offset < archivoEnviar.length()) {

                        //Calculo el tamaño del paquete que voy a enviar con un maximo de 1024
                        int length = (int) Math.min(archivoEnviar.length() - offset, 1024); // Tamaño de los Paquetes que se quiere enviar en este caso 1024 Bytes

                        //Creo un array que almacenara la informacion del buffer, tiene el tamaño necesario
                        byte buffer[] = new byte[length];
                        bis.read(buffer, offset, length);

                        //envio el paquete de datos.
                        bufferDatosSalida.write(buffer);

                        //muevo el offset y a seguir enviando
                        offset += length;
                        System.out.println("enviando datos: " + offset);
                    }

                    System.out.println("informacion envida al cliente");

                    //Cierro bis
                    bis.close();

                    break;
                case "carga":

                    String nombreArchivo = bufferDatosEntrada.readUTF(); // recibo en nombre del archivo
                    //Creo el Buffer de escritura para almacenar el archivo recibido en disco con el nombre que recibimos.
                    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(nombreArchivo)); // pongo el nombre.
  
                    //mientras este recibiendo informacion seguira escibiendo
                    while (bufferDatosEntrada.available() > 0) {
                    
                        // Capturo el tamaño del paquete a recibir
                        int length = bufferDatosEntrada.available();
                        System.out.println("Tamaño del paq a recibir" + length);
                        // Creo un array del tamaño del paquete a recibir
                        byte[] buffer = new byte[length];

                        //Escribo en el buffer el paquete recibido
                        buffer = bufferDatosEntrada.readAllBytes();
                        bos.write(buffer);

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
