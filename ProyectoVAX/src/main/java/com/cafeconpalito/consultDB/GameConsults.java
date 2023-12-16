/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.consultDB;

import com.cafeconpalito.entities.Genero;
import com.cafeconpalito.entities.Juego;
import com.cafeconpalito.registerGameData.gameRegisterInfo;
import com.cafeconpalito.staticElements.ConectionBBDD;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * @author CafeConPalito
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
    
    public static void insercion() {
        //insercion
        EntityManager em = ConectionBBDD.getEm();
        
        Query insercion = em.createNativeQuery("insert into juego (titulo, descripcion, imagen, fecha, numdescargas, precio, idusuario) values (:titulo, :descripcion, :imagen, :fecha, :numdescargas, :precio, :idusuario);");
        em.getTransaction().begin();
        
        insercion.setParameter("titulo", gameRegisterInfo.getTitle());
        insercion.setParameter("descripcion", gameRegisterInfo.getDescription());
        insercion.setParameter("imagen", gameRegisterInfo.getImage());
        insercion.setParameter("fecha", gameRegisterInfo.getLaunchDate());
        insercion.setParameter("numdescargas", 0);//al crearse siempre es 0
        insercion.setParameter("precio", gameRegisterInfo.getPrice());
        insercion.setParameter("idusuario",1);// falta   <-----------------------------------------------------    
        
        insercion.executeUpdate();
        em.clear();
        em.getTransaction().commit();
    }
    public static ArrayList<Juego> getNewGameid(String tittle) {
        Query q = ConectionBBDD.getEm().createNamedQuery("Juego.findByTitulo");
        q.setParameter("titulo", tittle);
        return (ArrayList<Juego>) q.getResultList();

    }

}
