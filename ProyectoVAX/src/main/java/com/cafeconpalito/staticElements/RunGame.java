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
 *
 * @author damt207
 */
public class RunGame {

    private String gameName = null;
    private File gamePath = null;

    public RunGame(String gameName) {
        this.gameName = gameName;
    }

    public void runGame() {

        String gameDir = "games" + File.separator + gameName;
        File directory = new File(gameDir);

        String[] flist = directory.list();
        if (flist == null) {
            //Si el juego no esta lo descarga!
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
                        gamePath = new File(gameDir + File.separator + filename);

                    }

                }
            }

        }else {
            System.out.println("ERROR INEXPLICABLE");
        }

        ProcessBuilder pb = new ProcessBuilder("CMD", "/c", gamePath.getAbsolutePath());
        try {
            pb.start();
        } catch (IOException ex) {
            Logger.getLogger(RunGame.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }

}
