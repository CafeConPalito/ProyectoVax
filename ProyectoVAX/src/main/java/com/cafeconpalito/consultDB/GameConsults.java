/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.consultDB;

import com.cafeconpalito.entities.Genero;
import com.cafeconpalito.entities.Juego;
import com.cafeconpalito.staticElements.ConectionBBDD;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.persistence.Query;

/**
 *
 * @author Ramiro
 */
public class GameConsults {

    public static ArrayList<Juego> getGameData(int idGame) {
        Query q = ConectionBBDD.getEm().createNamedQuery("Juego.findByIdjuego");
        q.setParameter("idjuego", idGame);
        return (ArrayList<Juego>) q.getResultList();

    }

    public static ObservableList<String> getGenreList() {
        Query q = ConectionBBDD.getEm().createNamedQuery("Genero.findAll");
        ArrayList<Genero> r = (ArrayList<Genero>) q.getResultList();
        ObservableList<String> items = FXCollections.observableArrayList();
        
        r.forEach(g -> {
            items.add(g.getName());
        });
                
        return items;
    }

}
