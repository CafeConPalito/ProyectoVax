/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.userLogedData;

import java.util.Date;

/**
 *
 * @author CafeConPalito
 */
public class UserLogedInfo {

    private static boolean userIsLoged = false;
    private static boolean userIsDeveloper = false; //Rol
    private static int UserID; //idusuario en BBDD
    private static String Alias;
    private static String UsuarioUrlImagen;
    private static int Region;
    private static String Email;
    private static String Nombre;
    private static String Apellido1;
    private static String Apellido2;
    private static Date FechaNacimiento;

    /**
     * Setea toda la informacion del usuario recibiendo la informacion por parametros
     * @param UserID
     * @param Alias
     * @param UsuarioUrlImagen
     * @param Region
     * @param Email
     * @param Nombre
     * @param Apellido1
     * @param Apellido2
     * @param FechaNacimiento
     * @param rol 
     */
    public static void constructUser(int UserID, String Alias, String UsuarioUrlImagen, int Region, String Email, String Nombre, String Apellido1, String Apellido2, Date FechaNacimiento, boolean rol) {
        UserLogedInfo.UserID = UserID;
        UserLogedInfo.Alias = Alias;
        UserLogedInfo.UsuarioUrlImagen = UsuarioUrlImagen;
        UserLogedInfo.Region = Region;
        UserLogedInfo.Email = Email;
        UserLogedInfo.Nombre = Nombre;
        UserLogedInfo.Apellido1 = Apellido1;
        UserLogedInfo.Apellido2 = Apellido2;
        UserLogedInfo.FechaNacimiento = FechaNacimiento;
        userIsDeveloper = rol;
        userIsLoged = true;
    }

    /**
     * Vuelve a poner los datos del usuario como al inicio
     */
    public static void logoutUser() {
        userIsLoged = false;
        userIsDeveloper = false;
        UserID = 0;
        Alias = "";
        UsuarioUrlImagen = "";
        Region = 0;
        Email = "";
        Nombre = "";
        Apellido1 = "";
        Apellido2 = "";
        FechaNacimiento = null;
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

    public static int getRegion() {
        return Region;
    }

    public static void setRegion(int Region) {
        UserLogedInfo.Region = Region;
    }

    public static Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public static void setFechaNacimiento(Date FechaNacimiento) {
        UserLogedInfo.FechaNacimiento = FechaNacimiento;
    }

}
