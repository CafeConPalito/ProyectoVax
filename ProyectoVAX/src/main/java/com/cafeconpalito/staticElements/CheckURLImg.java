/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.cafeconpalito.staticElements;

import java.net.URL;

/**
 *
 * @author Albano Díez de Paulino
 */
public class CheckURLImg {

     /**
     * Comprobar la URL de una imagen si es correcta deja continuar
     *
     * @param URLName
     * @return
     */
    public static boolean exists(String URLName) {

        //Comprueba el tipo de archivo si es correcto continua
        if (URLName.endsWith(".jpg") || URLName.endsWith(".png") || URLName.endsWith(".gif") || URLName.endsWith(".bmp") || URLName.endsWith(".jpeg")) {
            try {
                new URL(URLName).toURI();
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        
        return false;

        // PRUEBAS
        /*
        InputStream input = null;
        try {

            input = (new URL(urlImage)).openStream();
            input.close();
            infoGameImage.setImage(new Image(urlImage));
            System.out.println("imagen correcta carago la del la BBDD");
            
        } catch (IOException ex) {
            System.out.println("la imagen no va bien cargo dejo la de serie");
        } finally {
            if (input != null) {
                input.close();
            }

        }
         */
 /*
        Image image = new Image(urlImage);
        if (image.isError()) {
            System.out.println("error al leer la imagen");
            
        } else {
            System.out.println("imagen ok");
        }
         */
 /*
        boolean result = false;
        try {
            InputStream input = (new URL(URLName)).openStream();
            result = true;
        } catch (IOException ex) {
            System.out.println("Image doesnot exits :");
        }
        return result;
         */
    }
}
