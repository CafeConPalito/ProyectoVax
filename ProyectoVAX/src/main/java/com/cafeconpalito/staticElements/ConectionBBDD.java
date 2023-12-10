/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.staticElements;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author produccion
 */
public class ConectionBBDD {
    
    private static EntityManagerFactory emf;
    private static EntityManager em; 
    
    
    //EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.cafeconpalito_ProyectoVAX_jar_1.0-SNAPSHOTPU");
    //EntityManager em = emf.createEntityManager();
    
    /**
     * devuelve la conexion
     * @return 
     */
    public static EntityManager getEm(){
        start();
        return em;
    }

    /**
     * inicia la conexion
     */
    public static void start(){
                
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("com.cafeconpalito_ProyectoVAX_jar_1.0-SNAPSHOTPU");
        }

        if (em == null) {
            em = emf.createEntityManager();
        }

    }
    
    /**
     * cierra las conexiones
     */
    public static void close(){
        
        if (em != null) {
            em.close();
        }
        
        if (emf != null) {
            emf.close();
        }
    }

}
