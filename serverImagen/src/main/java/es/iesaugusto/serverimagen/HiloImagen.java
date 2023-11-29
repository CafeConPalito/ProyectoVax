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
public class HiloImagen implements Runnable{

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
                    
                    //Se necesita un Array de Bytes para almacenar la informacion con el tamaño del archivo.
                    byte[] arrayDeBitesArchivo = new byte[(int) archivoEnviar.length()];
                    
                    //Creo un Buffer para leer el archivo
                    BufferedInputStream bis = new BufferedInputStream(new FileInputStream(archivoEnviar)); 
                    
                    //Leo con el buffer el archivo ya lo tengo en memoria.
                    bis.read(arrayDeBitesArchivo, 0, arrayDeBitesArchivo.length);
                    //---------
                    
                    //--------- CLiente tiene que escuchar
                    
                    //ENVIO NOMBRE ARCHIVO
                    bufferDatosSalida.writeUTF(archivoEnviar.getName());
                        
                    //bufferDatosSalida.write(arrayDeBitesArchivo, 0, arrayDeBitesArchivo.length);
                    
                    //ENVIO DATOS DEL ARCHIVO
                    //Envieando la info de 1024 en 1024 Bytes.
                    
                    //ESTO LO ENVIA TODO DE GOLPE
                    //bufferDatosSalida.write(arrayDeBitesArchivo, 0, arrayDeBitesArchivo.length);
                    
                    System.out.println("Opcion del cliente: " + opcion);
                    
                    int offset = 0; // Permite identificar la posicion desde la que se va a empezar a enviar en cada pasada.
                    
                    while (offset < arrayDeBitesArchivo.length) {
                        int length = Math.min(arrayDeBitesArchivo.length - offset, 1024); // Tamaño de los Paquetes que se quiere enviar en este caso 1024 Bytes
                        bufferDatosSalida.write(arrayDeBitesArchivo, offset, length);
                        offset += length;
                        System.out.println("enviando datos: " + offset);
                    }
                    
                    System.out.println("informacion envida al cliente");
                    
                    //Cierro bis
                    bis.close();
                    
                    break;
                case "carga":
                    
                    String nombreArchivo = bufferDatosEntrada.readUTF(); // recibo en nombre del archivo
                    
                    // Creo un array para recibir el archivo e ir almacenándolo
                    byte[] archivoRecibido = bufferDatosEntrada.readAllBytes(); // escribo en el array los datos enviados.
                    // Creo el buffer que voy a utilizar y escribo en la imagen
                    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(nombreArchivo)); // pongo el nombre.
                    bos.write(archivoRecibido);

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
