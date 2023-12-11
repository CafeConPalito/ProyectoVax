/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.staticElements;

import java.util.HashMap;
import java.util.Map;
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
     *
     * @return
     */
    public static EntityManager getEm() {
        start();
        return em;
    }

    /**
     * inicia la conexion
     */
    public static void start() {
        
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
    public static void close() {

        if (em != null) {
            em.close();
        }

        if (emf != null) {
            emf.close();
        }
    }

    public static void modifyEM(String newIP) {

        //si no esta iniciada la inicio
        System.out.println("\nAntes de Modificar");
        start();

        //Crea una nueva EntityManagerFactory con los datos que se necesitan
        EntityManagerFactory managerFactory = null;
        Map<String, String> persistenceMap = new HashMap<String, String>();

        persistenceMap.put("javax.persistence.jdbc.url", "jdbc:mysql://" + newIP + ":3306/vapor?zeroDateTimeBehavior=CONVERT_TO_NULL");
        persistenceMap.put("javax.persistence.jdbc.user", "root");
        persistenceMap.put("javax.persistence.jdbc.password", "12345678");
        persistenceMap.put("javax.persistence.jdbc.driver", "com.mysql.cj.jdbc.Driver");

        //Carga las entidades del Em original en el nuevo EntityManagerFactory
        managerFactory = Persistence.createEntityManagerFactory("com.cafeconpalito_ProyectoVAX_jar_1.0-SNAPSHOTPU", persistenceMap);

        //Una ves modificada vuelve a cargar la info en em
        System.out.println("\ndespues de modificar");
        em = managerFactory.createEntityManager();

    }

}
