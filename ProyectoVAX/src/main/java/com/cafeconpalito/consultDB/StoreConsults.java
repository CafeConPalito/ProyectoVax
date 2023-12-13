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
import com.cafeconpalito.userLogedData.UserLogedInfo;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import javax.persistence.Query;

/**
 *
 * @author produccion
 */
public class StoreConsults {

    private static ArrayList<GameInfoController> storeGames = new ArrayList<>();

    public static ArrayList<GameInfoController> getStoreGames() throws IOException {

        storeGames.clear();

        if (!UserLogedInfo.isUserIsLoged()) {
            Query q = ConectionBBDD.getEm().createNamedQuery("Juego.findAll");

            for (Juego j : (Collection<Juego>) q.getResultList()) {
                GameInfoController cg = new GameInfoController(j.getIdjuego(), j.getTitulo(), j.getNumdescargas() + "", j.getPrecio() + "", j.getImagen());
                storeGames.add(cg);
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
                    GameInfoController cg = new GameInfoController(j.getIdjuego(), j.getTitulo(), j.getNumdescargas() + "", j.getPrecio() + "", j.getImagen());
                    storeGames.add(cg);
                } else {
                    tienejuego = false;
                }

            }
            Collections.shuffle(storeGames);
            return storeGames;
        }

    }

    public static ArrayList<GameInfoController> filterStoreGames(String gameName, int gamePrice) throws IOException {

        storeGames.clear();
        
        if (!UserLogedInfo.isUserIsLoged()) {
            Query q = ConectionBBDD.getEm().createNamedQuery("Juego.findAll");

            Collection<Juego> aux = (Collection<Juego>) q.getResultList();
            Iterator<Juego> it = aux.iterator();
            while (it.hasNext()) {
                Juego i = it.next();
                if (!i.getTitulo().toLowerCase().contains(gameName.toLowerCase())) {
                    it.remove();
                }
            }
            Iterator<Juego> it2= aux.iterator();
            while (it2.hasNext()) {
                Juego i = it2.next();
 
                if (i.getPrecio() > gamePrice) {
                    it.remove();
                }

            }
            for (Juego j : aux) {
                GameInfoController cg = new GameInfoController(j.getIdjuego(), j.getTitulo(), j.getNumdescargas() + "", j.getPrecio() + "", j.getImagen());
                storeGames.add(cg);
            }

            //mueve el orden de los juegos para que no siempre salgan en el mismo orden
            Collections.shuffle(storeGames);
            return storeGames;
        } else {
            Query q = ConectionBBDD.getEm().createNamedQuery("Juego.findAll");

            boolean tienejuego = false;
            ArrayList<Juego> aux=new ArrayList();
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

            Iterator<Juego> it = aux.iterator();
            while (it.hasNext()) {
                Juego i = it.next();
                if (!i.getTitulo().toLowerCase().contains(gameName.toLowerCase())) {
                    it.remove();
                }

            }
            Iterator<Juego> it2= aux.iterator();
            while (it2.hasNext()) {
                Juego i = it2.next();
 
                if (i.getPrecio() > gamePrice) {
                    it.remove();
                }

            }
            for (Juego j : aux) {
                GameInfoController cg = new GameInfoController(j.getIdjuego(), j.getTitulo(), j.getNumdescargas() + "", j.getPrecio() + "", j.getImagen());
                storeGames.add(cg);
            }
            Collections.shuffle(storeGames);
            return storeGames;
            
        }

    }

}
