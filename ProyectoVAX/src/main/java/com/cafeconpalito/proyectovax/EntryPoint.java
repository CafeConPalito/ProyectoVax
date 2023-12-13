package com.cafeconpalito.proyectovax;

import com.cafeconpalito.staticElements.ConectionBBDD;
import com.cafeconpalito.staticElements.FrameDatosConex;

/**
 *
 * @author Albano Díez de Paulino
 */
public class EntryPoint {

    //PURETO 6666 Imagen Usuario
    //PUERTO 6665 Imagen Juego
    //PUERTO 6664 ZIP Upload
    //PUERTO 6663 ZIP Download
    
    //public static String serverIP = "localhost";
    public static String serverIP = "192.168.34.209";
    public static String user = "root";
    public static String pass = "12345678";

    public static String rutaImgUser = "/imguser/";
    public static String rutaImgGame = "/imggame/";

    public static void main(String[] args) {

        boolean conexCorrecta = true;
        while (conexCorrecta) {
            try {
                ConectionBBDD.createCustomEM(serverIP, user, pass);
                conexCorrecta=false;
            } catch (Exception e) {
                System.out.println("peto la conexion");
                FrameDatosConex fdc = new FrameDatosConex();
                fdc.setVisible(true);
                while (fdc.esperandoIP) {                    
                }
            }
        }

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
