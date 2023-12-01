/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.proyectovax;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

/**
 *
 * @author damt207
 */
public class MetodoRecursivo {
    
    public static Object buscarComponente(Pane pane, String idComponenteBuscado){
    
        ObservableList<Node> lista = pane.getChildren();
        for (Node i : lista) {
            System.out.println(i);
            buscarComponente((Pane) i, "asd");
        }
        
        System.out.println("aqui estoy");
        
        return null;
        
        /*
        //    public static void SetGameLayerRecursive(GameObject gameObject, int layer)
            {
                gameObject.layer = layer;
                foreach (Transform child in gameObject.transform)
                {
                    SetGameLayerRecursive(child.gameObject, layer);
                }
            }
         */
        
        
    }
    
}
