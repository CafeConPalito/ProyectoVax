/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.iesaugusto.serverimagen;

import java.awt.Image;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

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
                    //Enviar DATOS al Cliente.
                    File direccionImagen = new File("logo.png");
                    ImageIcon imagenEnviada = new ImageIcon(direccionImagen.getAbsolutePath());
                    
                    
                    ///////////////////////////LO DEJAMOS POR AQUI/////////////////////////////
                                        
                    System.out.println("Opcion del cliente: " + opcion);
                    bufferDatosSalida.writeUTF("ESTO ES LA INFORMACION!");
                    System.out.println("informacion envida al cliente");
                    
                    break;
                case "carga":
                    
                    //Recibir DATOS del cliente
                    System.out.println("Opcion del cliente: " + opcion);
                    String carga = bufferDatosEntrada.readUTF();
                    System.out.println("informacion recibida del cliente");
                    System.out.println("Datos: " + carga);
                    
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
