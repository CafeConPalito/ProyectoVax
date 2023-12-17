/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.staticElements;

import com.cafeconpalito.socket.SocketZipGameDownload;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Inicializa un juego de la biblioteca
 * @author CafeConPalito
 */
public class RunGame {

    private String gameName = null;
    private File gamePath = null;

    /**
     * Constructor para lanzar un juego, es necesario pasarle el nombre del juego que se quiere iniciar
     * @param gameName nombre del juego a iniciar
     */
    public RunGame(String gameName) {
        this.gameName = gameName;
    }

    /**
     * Metodo que inicializa un juego utilizando el nombre del juego pasado.
     * 
     */
    public void runGame() {

        //Directorio donde deberia estar el juego
        String gameDir = "games" + File.separator + gameName;
        File directory = new File(gameDir);

        //Revisa si el directorio del juego existe y tiene archivos
        String[] flist = directory.list();
        if (flist == null) {
            //Si el juego no esta lo descarga
            SocketZipGameDownload szgd = new SocketZipGameDownload(gameName);
            //recargo flist
            flist = directory.list();
        }

        //compruebo por si acaso que flits no sea nulo
        if (flist != null) {
            //Continua despues de la descarga
            //Busca en el directorio del juego si existe un .exe
            for (int i = 0; i < flist.length; i++) {
                String filename = flist[i];
                if (filename.endsWith(".exe")) {
                    System.out.println(filename + " found");
                    if (new File(gameDir + File.separator + filename).exists()) {
                        //Guarda la direccion del .exe si existe
                        gamePath = new File(gameDir + File.separator + filename);
                    }
                }
            }

        //Si flits es nulo la unica explicacion es que no se pudiera descargar el juego
        }else {
            System.out.println("ERROR INEXPLICABLE");
        }

        //si el .exe existe lo lanzara
        if (gamePath != null) {
            ProcessBuilder pb = new ProcessBuilder("CMD", "/c", gamePath.getAbsolutePath());
        try {
            pb.start();
        } catch (IOException ex) {
            Logger.getLogger(RunGame.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }
        
                
    }

}
