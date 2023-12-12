package com.cafeconpalito.proyectovax;

import com.cafeconpalito.staticElements.ConectionBBDD;

/**
 *
 * @author Albano Díez de Paulino
 */
public class EntryPoint {

    public static String serverIP = "192.168.34.209";
    public static String user = "root";
    public static String pass = "12345678";

    public static String rutaImgUser = "/imguser/";
    public static String rutaImgGame = "/imggame/";

    public static void main(String[] args) {

        //levado al init de la app
        ConectionBBDD.createCustomEM(serverIP, user, pass);

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
