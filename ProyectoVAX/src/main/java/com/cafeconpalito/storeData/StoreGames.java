/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.storeData;

import com.cafeconpalito.controllers.GameInfoController;
import com.cafeconpalito.entitis.Game;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author produccion
 */
public class StoreGames {
    
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


        
        //Consulto la Base de datos.
        ArrayList<Game> listaJuegosBBDD = consultarBBDD();
        
        //construyo un javaFX de cada juego
        for (Game game : listaJuegosBBDD) {
            GameInfoController cg = new GameInfoController(game.getIdJuego(), game.getTitulo(), game.getNumDescargas()+"", game.getPrecio()+"", game.getUrlImagen());
            storeGames.add(cg);
        }

    }
    
    /**
     * simula la conexion y lo que me devuelve la BBDD
     */
    private static ArrayList<Game> consultarBBDD(){
        
        //DE MOMENTO LOS CONSTRUYO A MANO        
        
        ArrayList<Game> listaJuegosBBDD = new ArrayList<>();
        
        
        //Simula lo que me devuelve la BBDD
        for (int i = 0; i < 10; i++) {
            int x = i + 1;
            Game g = new Game(x, ("juego " + x), (x*5.33), (x*6431), "https://m.media-amazon.com/images/I/413OEtICMlL._AC_UF894,1000_QL80_.jpg");
            listaJuegosBBDD.add(g);
        }
        
        return listaJuegosBBDD;
        
    }
    
}
