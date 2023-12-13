/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.registerUserData;

/**
 *
 * @author Ramiro
 */
public class userRegisterInfo {
    
    private static Integer regionNumber;
    private static Integer rolenumber;    
    private static String firstName;
    private static String firstSurname;
    private static String secondSurname;
    private static String birthDate;
    private static String region;
    private static String email;
    private static String nickname;
    private static String password;
    private static String rPassword;
    private static String image;
    private static String Role;
    
  
    
     public static void resetRegisterInfo(){
        
        firstName=null;
        firstSurname=null;
        secondSurname=null;
        birthDate=null;
        region=null;
        email=null;
        nickname=null;
        password=null;
        rPassword=null;
        image=null;
        Role=null;
        regionNumber=null;
        rolenumber=null;
         
        
    }

    public static Integer getRegionNumber() {
        return regionNumber;
    }

    public static void setRegionNumber(Integer regionNumber) {
        userRegisterInfo.regionNumber = regionNumber;
    }

    public static Integer getRolenumber() {
        return rolenumber;
    }

    public static void setRolenumber(Integer rolenumber) {
        userRegisterInfo.rolenumber = rolenumber;
    } 
     
    public static String getFirstName() {
        return firstName;
    }

    public static void setFirstName(String firstName) {
        userRegisterInfo.firstName = firstName;
    }

    public static String getFirstSurname() {
        return firstSurname;
    }

    public static void setFirstSurname(String firstSurname) {
        userRegisterInfo.firstSurname = firstSurname;
    }

    public static String getSecondSurname() {
        return secondSurname;
    }

    public static void setSecondSurname(String secondSurname) {
        userRegisterInfo.secondSurname = secondSurname;
    }

    public static String getBirthDate() {
        return birthDate;
    }

    public static void setBirthDate(String birthDate) {
        userRegisterInfo.birthDate = birthDate;
    }

    public static String getRegion() {
        return region;
    }

    public static void setRegion(String region) {
        userRegisterInfo.region = region;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        userRegisterInfo.email = email;
    }

    public static String getNickname() {
        return nickname;
    }

    public static void setNickname(String nickname) {
        userRegisterInfo.nickname = nickname;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        userRegisterInfo.password = password;
    }

    public static String getrPassword() {
        return rPassword;
    }

    public static void setrPassword(String rPassword) {
        userRegisterInfo.rPassword = rPassword;
    }

    public static String getImage() {
        return image;
    }

    public static void setImage(String image) {
        userRegisterInfo.image = image;
    }

    public static String getRole() {
        return Role;
    }

    public static void setRole(String Role) {
        userRegisterInfo.Role = Role;
    }

}
