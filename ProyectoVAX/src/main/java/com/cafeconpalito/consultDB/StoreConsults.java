/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.consultDB;

import com.cafeconpalito.controllers.GameInfoController;
import com.cafeconpalito.entitis.Game;
import com.cafeconpalito.staticElements.ConectionBBDD;
import com.cafeconpalito.entitiDB.Juego;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import javax.persistence.Query;

/**
 *
 * @author produccion
 */
public class StoreConsults {
    
    private static ArrayList<GameInfoController> storeGames = new ArrayList<>();

    
    public static ArrayList<GameInfoController> getStoreGames() throws IOException {
        
        actualizarStoreGames();
        
        //mueve el orden de los juegos para que no siempre salgan en el mismo orden
        Collections.shuffle(storeGames);
        return storeGames;
        
    }

    /**
     * metodo que actualiza los juegos de la tienda quitando los que el jugador ya tiene
     */
    private static void actualizarStoreGames() throws IOException{
        
        //Limpio la lista.
        storeGames.clear();
        
        //construyo un javaFX de cada juego
        for (Juego j : consultarBBDD()) {
            GameInfoController cg = new GameInfoController(j.getIdjuego(), j.getTitulo(), j.getNumdescargas()+"", j.getPrecio()+"", j.getImagen());
            storeGames.add(cg);
        }

    }
    
    /**
     * simula la conexion y lo que me devuelve la BBDD
     */
    private static Collection<Juego> consultarBBDD(){
        
        Query q = ConectionBBDD.getEm().createNamedQuery("Juego.findAll");
        return q.getResultList();
        
    }

}
