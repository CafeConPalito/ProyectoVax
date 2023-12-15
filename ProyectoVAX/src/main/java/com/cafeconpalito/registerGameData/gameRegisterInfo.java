/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.registerGameData;

/**
 *
 * @author Ramiro
 */
public class gameRegisterInfo {
    
    private static String title;
    private static String description;    
    private static Double price;
    private static String image;
    private static String launchDate;
    private static String genre;
    private static String pegi;
    private static String cero;
    private static String esrb;
    private static String acb;
    private static String usk;
    
    
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

    public static String getGenre() {
        return genre;
    }

    public static void setGenre(String genre) {
        gameRegisterInfo.genre = genre;
    }

    public static String getPegi() {
        return pegi;
    }

    public static void setPegi(String pegi) {
        gameRegisterInfo.pegi = pegi;
    }

    public static String getCero() {
        return cero;
    }

    public static void setCero(String cero) {
        gameRegisterInfo.cero = cero;
    }

    public static String getEsrb() {
        return esrb;
    }

    public static void setEsrb(String esrb) {
        gameRegisterInfo.esrb = esrb;
    }

    public static String getAcb() {
        return acb;
    }

    public static void setAcb(String acb) {
        gameRegisterInfo.acb = acb;
    }

    public static String getUsk() {
        return usk;
    }

    public static void setUsk(String usk) {
        gameRegisterInfo.usk = usk;
    }
    
    
    
}
