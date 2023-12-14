/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.consultDB;

import com.cafeconpalito.controllers.GameInfoController;
import com.cafeconpalito.entities.Biblioteca;
import com.cafeconpalito.entities.Genero;
import com.cafeconpalito.staticElements.ConectionBBDD;
import com.cafeconpalito.entities.Juego;
import com.cafeconpalito.proyectovax.EntryPoint;
import com.cafeconpalito.staticElements.CheckURLImg;
import com.cafeconpalito.userLogedData.UserLogedInfo;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import javafx.scene.image.Image;
import javax.persistence.Query;

/**
 *
 * @author produccion
 */
public class LibraryConsults {

    private static ArrayList<GameInfoController> storeGames = new ArrayList<>();

    public static ArrayList<GameInfoController> getStoreGames() throws IOException {

        storeGames.clear();

        Query q = ConectionBBDD.getEm().createNamedQuery("Juego.findAll");

        for (Juego j : (Collection<Juego>) q.getResultList()) {
            for (Biblioteca b : (Collection<Biblioteca>) j.getBibliotecaCollection()) {

                if (b.getIdusuario().getIdusuario() == UserLogedInfo.getUserID()) {
                    String URL = "http://" + EntryPoint.getServerIP() + ":80" + EntryPoint.rutaImgGame + j.getImagen();
                    if (CheckURLImg.exists(URL)) {
                        GameInfoController cg = new GameInfoController(j.getIdjuego(), j.getTitulo(), j.getNumdescargas() + "", j.getPrecio() + "", URL);
                        cg.getPurchaseButton().setText("Download");
                        storeGames.add(cg);
                        break;
                    } else {
                        GameInfoController cg = new GameInfoController(j.getIdjuego(), j.getTitulo(), j.getNumdescargas() + "", j.getPrecio() + "", j.getImagen());
                        cg.getPurchaseButton().setText("Download");
                        storeGames.add(cg);
                        break;
                    }
                }

            }

        }
        Collections.shuffle(storeGames);
        return storeGames;
    }

    public static ArrayList<GameInfoController> filterStoreGames(String gameName, int gamePrice) throws IOException {

        storeGames.clear();

        Query q = ConectionBBDD.getEm().createNamedQuery("Juego.findAll");

        ArrayList<Juego> aux = new ArrayList();
        for (Juego j : (Collection<Juego>) q.getResultList()) {
            for (Biblioteca b : (Collection<Biblioteca>) j.getBibliotecaCollection()) {

                if (b.getIdusuario().getIdusuario() == UserLogedInfo.getUserID()) {
                    aux.add(j);
                }

            }

        }

        filtro(aux, gameName, gamePrice);

        for (Juego j : aux) {
            String URL = "http://" + EntryPoint.getServerIP() + ":80" + EntryPoint.rutaImgGame + j.getImagen();
            if (CheckURLImg.exists(URL)) {
                GameInfoController cg = new GameInfoController(j.getIdjuego(), j.getTitulo(), j.getNumdescargas() + "", j.getPrecio() + "", URL);
                cg.getPurchaseButton().setText("Download");
                storeGames.add(cg);
            } else {
                GameInfoController cg = new GameInfoController(j.getIdjuego(), j.getTitulo(), j.getNumdescargas() + "", j.getPrecio() + "", j.getImagen());
                cg.getPurchaseButton().setText("Download");
                storeGames.add(cg);
            }

        }
        Collections.shuffle(storeGames);
        return storeGames;

    }

    private static void filtro(Collection<Juego> col, String gameName, int gamePrice) {
        Iterator<Juego> it = col.iterator();
        while (it.hasNext()) {
            Juego i = it.next();
            if (!i.getTitulo().toLowerCase().contains(gameName.toLowerCase())) {
                it.remove();
            }
        }

        Iterator<Juego> it2 = col.iterator();

        while (it2.hasNext()) {
            Juego i = it2.next();

            if (i.getPrecio() > gamePrice) {
                it2.remove();
            }

        }
    }

}
