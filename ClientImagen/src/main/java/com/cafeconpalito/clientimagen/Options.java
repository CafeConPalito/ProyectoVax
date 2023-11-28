/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.clientimagen;

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
 * @author Ramiro
 */
public class Options {

    static String direccion= "192.168.34.4";
    static Socket servidor;
    static final int PUERTO = 6666;


    public static void uploadImg() {

        try {
            servidor = new Socket(direccion, PUERTO);
            System.out.println("conexion realizada con exito");

            DataInputStream bufferDatosEntrada = new DataInputStream(servidor.getInputStream());
            DataOutputStream bufferDatosSalida = new DataOutputStream(servidor.getOutputStream());   
            
            
            //1 Envío lo que quiero
            
            String opcion= "carga";
            bufferDatosSalida.writeUTF(opcion);
            
            // 2 Espero la respuesta
            
            //String datos= "ESTOS SON LOS DATOS!";
            
            File direccionImagen = new File("");
            ImageIcon imagen = new ImageIcon(direccionImagen.getName());
            //bufferDatosSalida.write(imagen);
            
            // 3 Cierro los búferes y servidor
            
            bufferDatosEntrada.close();
            bufferDatosSalida.close();
            servidor.close();
            
            System.out.println("soy el cliente y cierro la conexion");
            
        } catch (IOException ex) {
            Logger.getLogger(Options.class.getName()).log(Level.SEVERE, null, ex);
        }

        }

    

    public static void downloadImg() {
         try {
            servidor = new Socket(direccion, PUERTO);
            System.out.println("conexion realizada con exito");

            DataInputStream bufferDatosEntrada = new DataInputStream(servidor.getInputStream());
            DataOutputStream bufferDatosSalida = new DataOutputStream(servidor.getOutputStream());   
            
            
            //1 Envío lo que quiero
            
            String opcion= "descarga";
            bufferDatosSalida.writeUTF(opcion);
            
            // 2 Espero la respuesta
            
            ImageIcon imagen;
            
            String mensaje = bufferDatosEntrada.readUTF();
            System.out.println(mensaje);//AQUÍ ESTAMOS
            
            // 3 Cierro los búferes y servidor
            
            bufferDatosEntrada.close();
            bufferDatosSalida.close();
            servidor.close();
            
            System.out.println("soy el cliente y cierro la conexion");
            
        } catch (IOException ex) {
            Logger.getLogger(Options.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
