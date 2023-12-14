/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.consultDB;

import com.cafeconpalito.entities.Regulacion;
import com.cafeconpalito.staticElements.ConectionBBDD;
import java.util.ArrayList;
import javax.persistence.Query;

/**
 *
 * @author Ramiro
 */
public class RegulationConsults {
    
    /*
    
    SELECT regulacion.region, regulacion.nivel FROM regulacion
    INNER JOIN regulacion_juego ON regulacion.idregulacion = regulacion_juego.idregulacion
    INNER JOIN juego ON regulacion_juego.idjuego = juego.idjuego 
    WHERE juego.idjuego = 3;
    
    
    */
    
}
