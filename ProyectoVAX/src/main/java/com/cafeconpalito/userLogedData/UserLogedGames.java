/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.userLogedData;

import com.cafeconpalito.entitis.Game;
import java.util.ArrayList;

/**
 *
 * @author produccion
 */
public class UserLogedGames {
    
    private static ArrayList<Game> myGames;

    public static ArrayList<Game> getMyGames() {
        return myGames;
    }

    public static void setMyGames(ArrayList<Game> myGames) {
        UserLogedGames.myGames = myGames;
    }

}
