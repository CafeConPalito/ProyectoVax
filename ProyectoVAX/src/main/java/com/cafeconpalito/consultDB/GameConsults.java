/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.consultDB;

import com.cafeconpalito.entities.Juego;
import com.cafeconpalito.staticElements.ConectionBBDD;
import java.util.ArrayList;
import javax.persistence.Query;

/**
 *
 * @author Ramiro
 */
public class GameConsults {
    
    public static ArrayList<Juego> getGameData(int idGame){
        Query q = ConectionBBDD.getEm().createNamedQuery("Juego.findByIdjuego");
        q.setParameter("idjuego", idGame);
        return (ArrayList<Juego>) q.getResultList();
        
    }
    
    
    
}
