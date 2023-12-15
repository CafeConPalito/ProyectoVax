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
 *
 * @author Ramiro
 */
public class ForgetConsults {

    public static boolean userExists(String email) {
        Query q = ConectionBBDD.getEm().createNamedQuery("Usuario.findByEmail");
        q.setParameter("email", email);
        ArrayList<Usuario> l = (ArrayList<Usuario>) q.getResultList();

        if (!l.isEmpty()) {
            return true;
        }
        return false;
    }

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
