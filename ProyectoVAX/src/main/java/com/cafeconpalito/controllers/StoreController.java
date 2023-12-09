/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cafeconpalito.controllers;

import com.cafeconpalito.storeData.StoreGames;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.layout.TilePane;

/**
 * FXML Controller class
 *
 * @author produccion
 */
public class StoreController implements Initializable {

    @FXML
    private TilePane MyTilePane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            
            MyTilePane.getChildren().clear();
            MyTilePane.getChildren().addAll(StoreGames.getStoreGames());
            
        } catch (IOException ex) {
            System.err.println("ERROR AL CARGAR LOS JUEGOS");
        }
    }

}
