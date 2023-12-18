/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.staticElements;

import java.net.URL;

/**
 *
 * @author damt207
 */
public class HiloURLExist implements Runnable {

    String URLimagen;
    boolean exists = false;
    boolean comprobar = false;
    
    
    //Implementacion Rapida para no tener que rehacer mucho codigo intentando lanzar hilos para comprobar imagenes de URL de AWS que va muy lento
    /**
     * Constructor con parametro que lanza
     * @param URLimagen 
     */
    public HiloURLExist(String URLimagen) {
        this.URLimagen = URLimagen;
        run();
    }

    @Override
    public void run() {
        try {
            new URL(URLimagen).toURI();
            exists = true;
        } catch (Exception e) {
            exists = false;
        }finally{
            comprobar=true;
        }
        
    }

    public boolean isComprobar() {
        return comprobar;
    }

    public boolean isExists() {
        return exists;
    }
    
    

}
