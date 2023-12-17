/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.staticElements;

import com.cafeconpalito.proyectovax.EntryPoint;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author CafeConPalito
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
        //start();
        if (!startEntryPointValues()) {
            return null;
        }
        return em;
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

    public static boolean startEntryPointValues() {

        //Crea una nueva EntityManagerFactory con los datos que se necesitan
        try {
            EntityManager emAux = null;
            EntityManagerFactory managerFactory = null;
            Map<String, String> persistenceMap = new HashMap<String, String>();

            persistenceMap.put("javax.persistence.jdbc.url", "jdbc:mysql://" + EntryPoint.serverIP + ":3306/vapor?zeroDateTimeBehavior=CONVERT_TO_NULL");
            persistenceMap.put("javax.persistence.jdbc.user", EntryPoint.user);
            persistenceMap.put("javax.persistence.jdbc.password", EntryPoint.pass);
            persistenceMap.put("javax.persistence.jdbc.driver", "com.mysql.cj.jdbc.Driver");

            //Carga las entidades del Em original en el nuevo EntityManagerFactory
            managerFactory = Persistence.createEntityManagerFactory("com.cafeconpalito_ProyectoVAX_jar_1.0-SNAPSHOTPU", persistenceMap);

            //Una ves modificada vuelve a cargar la info en em
            emf = managerFactory;

            //System.out.println("\ndespues de modificar");
            emAux = managerFactory.createEntityManager();
            em = emAux;
            return true;
        } catch (Exception e) {
            //si falla la conexion em se queda en null
            em = null;
            return false;
        }

    }

    public static boolean createCustomEMonlyIP(String newIP) {

        //Crea una nueva EntityManagerFactory con los datos que se necesitan
        try {
            EntityManager emAux = null;
            EntityManagerFactory managerFactory = null;
            Map<String, String> persistenceMap = new HashMap<String, String>();

            persistenceMap.put("javax.persistence.jdbc.url", "jdbc:mysql://" + newIP + ":3306/vapor?zeroDateTimeBehavior=CONVERT_TO_NULL");
            persistenceMap.put("javax.persistence.jdbc.user", "root");
            persistenceMap.put("javax.persistence.jdbc.password", "12345678");
            persistenceMap.put("javax.persistence.jdbc.driver", "com.mysql.cj.jdbc.Driver");

            //Carga las entidades del Em original en el nuevo EntityManagerFactory
            managerFactory = Persistence.createEntityManagerFactory("com.cafeconpalito_ProyectoVAX_jar_1.0-SNAPSHOTPU", persistenceMap);

            //Una ves modificada vuelve a cargar la info en em
            emf = managerFactory;

            //System.out.println("\ndespues de modificar");
            emAux = managerFactory.createEntityManager();
            em = emAux;
            EntryPoint.serverIP = newIP;
            
            return true;
        } catch (Exception e) {
            //si falla la conexion em se queda en null
            em = null;
            return false;
        }

    }

}
