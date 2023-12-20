/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.registerGameData;

/**
 *
  * @author CafeConPalito
 */
public class gameRegisterInfo {
    
    private static String title;
    private static String description;    
    private static Double price;
    private static String image;
    private static String launchDate;
    private static Integer genre;
    private static Integer pegi;
    private static Integer cero;
    private static Integer esrb;
    private static Integer acb;
    private static Integer usk;
    
    /**
     * Pone todos los datos del registro de un Juego a nulo,
     * Usuado al terminar un registro
     */
    public static void resetGameInfo(){
        
        title=null;
        description=null;
        price=null;
        image=null;
        launchDate=null;
        genre=null;
        pegi=null;
        cero=null;
        esrb=null;
        acb=null;
        usk=null;
      
    }
    

    public static String getTitle() {
        return title;
    }

    public static void setTitle(String title) {
        gameRegisterInfo.title = title;
    }

    public static String getDescription() {
        return description;
    }

    public static void setDescription(String description) {
        gameRegisterInfo.description = description;
    }

    public static Double getPrice() {
        return price;
    }

    public static void setPrice(Double price) {
        gameRegisterInfo.price = price;
    }

    public static String getImage() {
        return image;
    }

    public static void setImage(String image) {
        gameRegisterInfo.image = image;
    }

    public static String getLaunchDate() {
        return launchDate;
    }

    public static void setLaunchDate(String launchDate) {
        gameRegisterInfo.launchDate = launchDate;
    }

    public static int getGenre() {
        return genre;
    }

    public static void setGenre(int genre) {
        gameRegisterInfo.genre = genre;
    }

    public static Integer getPegi() {
        return pegi;
    }

    public static void setPegi(Integer pegi) {
        gameRegisterInfo.pegi = pegi;
    }

    public static Integer getCero() {
        return cero;
    }

    public static void setCero(Integer cero) {
        gameRegisterInfo.cero = cero;
    }

    public static Integer getEsrb() {
        return esrb;
    }

    public static void setEsrb(Integer esrb) {
        gameRegisterInfo.esrb = esrb;
    }

    public static Integer getAcb() {
        return acb;
    }

    public static void setAcb(Integer acb) {
        gameRegisterInfo.acb = acb;
    }

    public static Integer getUsk() {
        return usk;
    }

    public static void setUsk(Integer usk) {
        gameRegisterInfo.usk = usk;
    }
    
    
    
}
