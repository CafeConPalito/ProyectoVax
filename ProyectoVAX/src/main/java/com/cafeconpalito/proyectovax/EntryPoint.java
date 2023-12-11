package com.cafeconpalito.proyectovax;

import com.cafeconpalito.staticElements.ConectionBBDD;

/**
 *
 * @author Albano Díez de Paulino
 */
public class EntryPoint {
    
    public static void main(String[] args) {
        
        //levado al init de la app
       
        ConectionBBDD.start();
        
        App.main(args);

    }

}
