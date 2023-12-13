/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.cafeconpalito.socket;

import com.google.common.io.Files;
import java.io.File;

/**
 *
 * @author damt207
 */
public class PruebasCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        //PRUEBAS DEL CLIENTE IMAGEN
        
        File f = new File("daniel.png");
        
        String path = f.getAbsolutePath();
        String alias = "ALBANO ES TONTO";
        
        System.out.println(path);
        
        SocketImagUser siu = new SocketImagUser(alias, path);
        SocketImagGame sig = new SocketImagGame(alias, path);
        SocketZipGameUpload szgu = new SocketZipGameUpload(alias, path);

    }
    
}
