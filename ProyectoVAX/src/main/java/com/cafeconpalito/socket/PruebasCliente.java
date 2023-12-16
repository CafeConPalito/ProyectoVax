/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.cafeconpalito.socket;

import com.cafeconpalito.staticElements.RunGame;
import java.io.File;

/**
 *
 * @author CafeConPalito
 */
public class PruebasCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        //PRUEBAS DEL CLIENTE IMAGEN
        
        File f = new File("daniel.zip");
        
        String path = f.getAbsolutePath();
        String alias = "pajaro volando";
              
        //System.out.println(alias);
        //System.out.println(alias.replaceAll("\\s+",""));
        
        //SocketImagUser siu = new SocketImagUser(alias, path);
        //SocketImagGame sig = new SocketImagGame(alias, path);
        //SocketZipGameUpload szgu = new SocketZipGameUpload(alias, path);
        //SocketZipGameDownload szgd = new SocketZipGameDownload("da niel");
        
        //RunGame r = new RunGame("daniel");
        //r.runGame();
        
    }
    
}
