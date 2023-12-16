/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.consultDB;

import com.cafeconpalito.entities.Usuario;
import com.cafeconpalito.staticElements.ConectionBBDD;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * @author CafeConPalito
 * @author Ramiro
 */
public class ForgetConsults {

    /**
     * Comprueba por el email si el usuario existe en la BBDD
     * @param email email del usuario
     * @return true si encuentra el email
     */
    public static boolean userExists(String email) {
        Query q = ConectionBBDD.getEm().createNamedQuery("Usuario.findByEmail");
        q.setParameter("email", email);
        ArrayList<Usuario> l = (ArrayList<Usuario>) q.getResultList();

        if (!l.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * Comprueba si el email del usuario y el alias coinciden en la BBDD
     * @param email email del usuario
     * @param alias alias del usuario 
     * @return devuelve true si la coinciden
     */
    public static boolean passwordCorrect(String email, String alias) {
        Query q = ConectionBBDD.getEm().createNamedQuery("Usuario.userAndAliasCorrect");
        q.setParameter("alias", alias);
        q.setParameter("email", email);
        ArrayList<Usuario> l = (ArrayList<Usuario>) q.getResultList();

        if (!l.isEmpty()) {
            return true;
        }
        return false;
    }

   
    /**
     * Actualiza la contraseña de un usuario en la BBDD utilizando el email
     * @param email email del usuario
     * @param pass nueva contraseña del usuario
     */
    public static void updatePWD(String email,String pass) {
        EntityManager em = ConectionBBDD.getEm();
        

        //Sentencia a cañon, no me pilla el cambio
        Query insercion = em.createNativeQuery("UPDATE usuario SET pwd = :pass WHERE idusuario=:iduser");
        em.getTransaction().begin();
        int id= getIdUser(email);
        System.out.println("Obtengo Id" +id);

        insercion.setParameter("pass", pass);
        insercion.setParameter("iduser", id);

        System.out.println("No puedo hacer update");
        insercion.executeUpdate();
        em.clear();
        em.getTransaction().commit();

    }
    
    /**
     * Devuelve un entero con el ID del usuario de la base del datos
     * si no lo encuentra devuelve 0
     * @param email email del usuario
     * @return devuelde el id del usuario, 0 si no lo encuentra
     */
    private static int getIdUser(String email) {
         Query q = ConectionBBDD.getEm().createNamedQuery("Usuario.findByEmail");
        q.setParameter("email", email);
        ArrayList<Usuario> l = (ArrayList<Usuario>) q.getResultList();

        for (Usuario usuario : l) {
            return usuario.getIdusuario();
        }
        return 0;

    }

}
