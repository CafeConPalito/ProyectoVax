/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.iesaugusto.serverimagen;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
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
            System.out.println("\t llega el cliente ");
            //se declaran los gru`pos de comunicacion con el cliente
            //flujo de entrada o lectura
            DataInputStream bufferDatosEntrada = new DataInputStream(cliente.getInputStream());
            //flujo de salida o escritura
            DataOutputStream bufferDatosSalida = new DataOutputStream(cliente.getOutputStream());
            //A partir de aquí se establece el protocolo de comunicacion
            System.out.println("Envio el mensaje para el cliente");
            bufferDatosSalida.writeUTF("usted es mi cliente:");
            
            bufferDatosEntrada.close();
            bufferDatosSalida.close();
            cliente.close();
            System.out.println("comunicacion con el cliente cerrada");
        } catch (IOException ex) {
            Logger.getLogger(HiloImagen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
