/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cafeconpalito.controllers;

import com.cafeconpalito.constructor.ConstructorGameInfoGood;
import com.cafeconpalito.proyectovax.App;
import com.cafeconpalito.storeData.StoreGames;
import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

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

        /*
        try {
            GameInfoGoodController gic = new GameInfoGoodController();
            //gic.getInfoGameTitle().setText("TITULO INVENT");
            
            
            //MyTilePane.getChildren().add(gic);
            
        } catch (IOException ex) {
            System.err.println("ERROR AL CREAR EL OBJETO GAME CONTROLLER");
            
        }
 
         */
        //FUNCIONA PER NO MOLA!
        /*
            try {
            // TODO

            MyTilePane.getChildren().clear();
            
            for (ConstructorGameInfoGood i : StoreGames.getStoreGames()) {
            MyTilePane.getChildren().add(i.getPane());
            }
            
            } catch (IOException ex) {
            System.out.println("Error al cargar la lista de Juegos en la Store");
            }
         */
    }

    @FXML
    private void mecagoento(ActionEvent event) {

        System.out.println("creo juego");
        try {
            GameInfoGoodController gic = new GameInfoGoodController();
            gic.getInfoGameTitle().setText("TITULO INVENT");

            MyTilePane.getChildren().add(gic);
        } catch (IOException ex) {
            System.err.println("ERROR AL CREAR EL OBJETO GAME CONTROLLER");

        }
    }

}
