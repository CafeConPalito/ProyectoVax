/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.consultDB;

import com.cafeconpalito.staticElements.ConectionBBDD;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Ramiro
 */
public class RegulationConsults {
    
    
    //insert into regulacion (region, nivel) values
    /**
     * Inserta la regulacion de un juego en la BBDD
     * @param idregulacion id de la regulacion que se quiere añadir
     * @param idjuego id del juego al que se quiere insertar
     */
    public static void insercion(Integer idregulacion,Integer idjuego) {
        //insercion
        EntityManager em = ConectionBBDD.getEm();
        
        
        Query insercion = em.createNativeQuery("insert into regulacion_juego(idregulacion,idjuego) values (:idregulacion, :idjuego);");
        em.getTransaction().begin();
        
        insercion.setParameter("idregulacion", idregulacion);
        insercion.setParameter("idjuego", idjuego);   
        
        insercion.executeUpdate();
        em.clear();
        em.getTransaction().commit();
    }
    
}
