/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.staticElements;


/**
 * @author CafeConPalito
 */
public class CheckURLImg {

    /**
     * Comprobar la URL de una imagen
     *
     * @param URLName
     * @return True si la imagen es accesible, False si no lo es
     */
    public static boolean exists(String URLName) {

        //Comprueba el tipo de archivo si es correcto continua
        if (URLName.endsWith(".jpg") || URLName.endsWith(".png") || URLName.endsWith(".gif") || URLName.endsWith(".bmp") || URLName.endsWith(".jpeg")) {
            //Llamar al hilo si se cumple esta condicion
            //Implementacion Rapida para no tener que rehacer mucho codigo intentando lanzar hilos para comprobar imagenes de URL de AWS que va muy lento
            HiloURLExist hue = new HiloURLExist(URLName);
            while (!hue.comprobar) {                
            }
            return hue.exists;
        }
        return false;
    }
}
