/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.userLogedData;

import java.util.Date;

/**
 *
 * @author produccion
 */
public class UserLogedInfo {
    
    private static boolean userIsLoged = false;
    private static boolean userIsDeveloper = false; //Rol
    private static int UserID; //idusuario en BBDD
    private static String Username;
    private static String Alias;
    private static String UsuarioUrlImagen;
    
    //Creo que no hacen falta pero por si las moscas ;)
    private static String Email;
    private static String Nombre;
    private static String Apellido1;
    private static String Apellido2;
    private static String Region;
    private static Date FechaNacimiento;

    public static void contructUser(){
        
    }
    
    public static void logoutUser(){
        //poner todo a nulos
        
    }
    
    public static boolean isUserIsLoged() {
        return userIsLoged;
    }

    public static void setUserIsLoged(boolean userIsLoged) {
        UserLogedInfo.userIsLoged = userIsLoged;
    }

    public static boolean isUserIsDeveloper() {
        return userIsDeveloper;
    }

    public static void setUserIsDeveloper(boolean userIsDeveloper) {
        UserLogedInfo.userIsDeveloper = userIsDeveloper;
    }

    public static int getUserID() {
        return UserID;
    }

    public static void setUserID(int UserID) {
        UserLogedInfo.UserID = UserID;
    }

    public static String getUsername() {
        return Username;
    }

    public static void setUsername(String Username) {
        UserLogedInfo.Username = Username;
    }

    public static String getAlias() {
        return Alias;
    }

    public static void setAlias(String Alias) {
        UserLogedInfo.Alias = Alias;
    }

    public static String getUsuarioUrlImagen() {
        return UsuarioUrlImagen;
    }

    public static void setUsuarioUrlImagen(String UsuarioUrlImagen) {
        UserLogedInfo.UsuarioUrlImagen = UsuarioUrlImagen;
    }

    public static String getEmail() {
        return Email;
    }

    public static void setEmail(String Email) {
        UserLogedInfo.Email = Email;
    }

    public static String getNombre() {
        return Nombre;
    }

    public static void setNombre(String Nombre) {
        UserLogedInfo.Nombre = Nombre;
    }

    public static String getApellido1() {
        return Apellido1;
    }

    public static void setApellido1(String Apellido1) {
        UserLogedInfo.Apellido1 = Apellido1;
    }

    public static String getApellido2() {
        return Apellido2;
    }

    public static void setApellido2(String Apellido2) {
        UserLogedInfo.Apellido2 = Apellido2;
    }

    public static String getRegion() {
        return Region;
    }

    public static void setRegion(String Region) {
        UserLogedInfo.Region = Region;
    }

    public static Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public static void setFechaNacimiento(Date FechaNacimiento) {
        UserLogedInfo.FechaNacimiento = FechaNacimiento;
    }

    
    
    
    
    
}
