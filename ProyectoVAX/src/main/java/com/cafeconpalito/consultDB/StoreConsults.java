/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.consultDB;

import com.cafeconpalito.controllers.GameInfoController;
import com.cafeconpalito.entities.Biblioteca;
import com.cafeconpalito.staticElements.ConectionBBDD;
import com.cafeconpalito.entities.Juego;
import com.cafeconpalito.proyectovax.EntryPoint;
import com.cafeconpalito.staticElements.CheckURLImg;
import com.cafeconpalito.userLogedData.UserLogedInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import javax.persistence.Query;

/**
 *
 * @author CafeConPalito
 */
public class StoreConsults {

    private static ArrayList<GameInfoController> storeGames = new ArrayList<>();

    /**
     * Consulta en la Base de datos la informacion de todos los juegos registrados
     * @return devuelve toda la lista si el usuario no esta logeado (invitado)
     * o los juegos que el usuario no tiene comprados
     * @throws IOException
     */
    public static ArrayList<GameInfoController> getStoreGames() throws IOException {

        
        
        storeGames.clear();

        if (!UserLogedInfo.isUserIsLoged()) {
            Query q = ConectionBBDD.getEm().createNamedQuery("Juego.findAll");

            for (Juego j : (Collection<Juego>) q.getResultList()) {
                String URL = "http://" + EntryPoint.getServerIP() + ":80" + EntryPoint.rutaImgGame + j.getImagen();
                if (CheckURLImg.exists(URL)) {
                    GameInfoController cg = new GameInfoController(j.getIdjuego(), j.getTitulo(), j.getNumdescargas() + "", j.getPrecio() + "", URL);
                    storeGames.add(cg);
                } else {
                    GameInfoController cg = new GameInfoController(j.getIdjuego(), j.getTitulo(), j.getNumdescargas() + "", j.getPrecio() + "", j.getImagen());
                    storeGames.add(cg);
                }
            }

            Collections.shuffle(storeGames);
            return storeGames;
        } else {
            Query q = ConectionBBDD.getEm().createNamedQuery("Juego.findAll");

            boolean tienejuego = false;
            for (Juego j : (Collection<Juego>) q.getResultList()) {
                for (Biblioteca b : (Collection<Biblioteca>) j.getBibliotecaCollection()) {

                    if (b.getIdusuario().getIdusuario() == UserLogedInfo.getUserID()) {
                        tienejuego = true;
                        break;
                    }

                }
                if (!tienejuego) {
                    String URL = "http://" + EntryPoint.getServerIP() + ":80" + EntryPoint.rutaImgGame + j.getImagen();
                    if (CheckURLImg.exists(URL)) {
                        GameInfoController cg = new GameInfoController(j.getIdjuego(), j.getTitulo(), j.getNumdescargas() + "", j.getPrecio() + "", URL);
                        storeGames.add(cg);
                        tienejuego = false;
                    } else {
                        GameInfoController cg = new GameInfoController(j.getIdjuego(), j.getTitulo(), j.getNumdescargas() + "", j.getPrecio() + "", j.getImagen());
                        storeGames.add(cg);
                        tienejuego = false;
                    }
                } else {
                    tienejuego = false;
                }

            }
            Collections.shuffle(storeGames);
            return storeGames;
        }

    }

    /**
     * Aplica filtros a la lista de juegos en funcion de si el usuario esta logeado o no
     * mostrando los que no tiene comprados
     * @param gameName nombre del juego a buscar
     * @param gamePrice precio del juego a buscar
     * @return devuelve un ArrayList de GameInfoController con los juegos filtrados
     * @throws IOException 
     */
    public static ArrayList<GameInfoController> filterStoreGames(String gameName, int gamePrice) throws IOException {

        storeGames.clear();

        if (!UserLogedInfo.isUserIsLoged()) {
            Query q = ConectionBBDD.getEm().createNamedQuery("Juego.findAll");

            Collection<Juego> aux = (Collection<Juego>) q.getResultList();
            filtro(aux, gameName, gamePrice);

            for (Juego j : aux) {
                String URL = "http://" + EntryPoint.getServerIP() + ":80" + EntryPoint.rutaImgGame + j.getImagen();
                if (CheckURLImg.exists(URL)) {
                    GameInfoController cg = new GameInfoController(j.getIdjuego(), j.getTitulo(), j.getNumdescargas() + "", j.getPrecio() + "", URL);
                    storeGames.add(cg);
                } else {
                    GameInfoController cg = new GameInfoController(j.getIdjuego(), j.getTitulo(), j.getNumdescargas() + "", j.getPrecio() + "", j.getImagen());
                    storeGames.add(cg);
                }

            }

            //mueve el orden de los juegos para que no siempre salgan en el mismo orden
            Collections.shuffle(storeGames);
            return storeGames;
        } else {
            Query q = ConectionBBDD.getEm().createNamedQuery("Juego.findAll");

            boolean tienejuego = false;
            ArrayList<Juego> aux = new ArrayList();
            for (Juego j : (Collection<Juego>) q.getResultList()) {
                for (Biblioteca b : (Collection<Biblioteca>) j.getBibliotecaCollection()) {
                    if (b.getIdusuario().getIdusuario() == UserLogedInfo.getUserID()) {
                        tienejuego = true;
                        break;
                    }

                }
                if (!tienejuego) {
                    aux.add(j);
                } else {
                    tienejuego = false;
                }

            }

            filtro(aux, gameName, gamePrice);

            for (Juego j : aux) {
                String URL = "http://" + EntryPoint.getServerIP() + ":80" + EntryPoint.rutaImgGame + j.getImagen();
                if (CheckURLImg.exists(URL)) {
                    GameInfoController cg = new GameInfoController(j.getIdjuego(), j.getTitulo(), j.getNumdescargas() + "", j.getPrecio() + "", URL);
                    storeGames.add(cg);
                } else {
                    GameInfoController cg = new GameInfoController(j.getIdjuego(), j.getTitulo(), j.getNumdescargas() + "", j.getPrecio() + "", j.getImagen());
                    storeGames.add(cg);
                }

            }
            Collections.shuffle(storeGames);
            return storeGames;

        }

    }

    /**
     * Aplica los filtros a la lista
     * @param col Collection de Juegos 
     * @param gameName nombre del juego para filtrar
     * @param gamePrice precio del juego para filtrar
     */
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
