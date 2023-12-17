package com.cafeconpalito.proyectovax;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author CafeConPalito
 * @author Maria Carmen Barrios Fernández
 * @author Ramiro Gutiérrez Valverde
 * @author Daniel Espinosa García
 * @author Albano Díez de Paulino
 */
public class EntryPoint {

    //PURETO 6666 Imagen Usuario
    //PUERTO 6665 Imagen Juego
    //PUERTO 6664 ZIP Upload
    //PUERTO 6663 ZIP Download
 
    public static String serverIP = "localhost";
    //public static String serverIP = "192.168.34.209";
    public static String user = "root";
    //public static String pass = "1234";
    //public static String pass = "12341234";
    public static String pass = "12345678";

    public static String rutaImgUser = "/imguser/";
    public static String rutaImgGame = "/imggame/";

    public static void main(String[] args) {

        Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
        
        App.main(args);

    }

    public static String getRutaImgUser() {
        return rutaImgUser;
    }

    public static void setRutaImgUser(String rutaImgUser) {
        EntryPoint.rutaImgUser = rutaImgUser;
    }

    public static String getRutaImgGame() {
        return rutaImgGame;
    }

    public static void setRutaImgGame(String rutaImgGame) {
        EntryPoint.rutaImgGame = rutaImgGame;
    }

    public static String getServerIP() {
        return serverIP;
    }

    public static void setServerIP(String serverIP) {
        EntryPoint.serverIP = serverIP;
    }

}
