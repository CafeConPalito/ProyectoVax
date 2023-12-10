/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cafeconpalito.controllers;

import com.cafeconpalito.consultDB.StoreConsults;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import javafx.scene.layout.TilePane;

/**
 * FXML Controller class
 *
 * @author produccion
 */
public class StoreController implements Initializable {

    @FXML
    private TilePane MyTilePane;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField genreTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            
            MyTilePane.getChildren().clear();
            MyTilePane.getChildren().addAll(StoreConsults.getStoreGames());
            
        } catch (IOException ex) {
            System.err.println("ERROR AL CARGAR LOS JUEGOS");
        }
    }

    @FXML
    private void nameEntryInfo(KeyEvent event) {
        
        MyTilePane.getChildren().clear();
        MyTilePane.getChildren().addAll(StoreConsults.filterStoreGames(nameTextField.getText(), genreTextField.getText(),""));
        
    }

    @FXML
    private void genreEntryInfo(KeyEvent event) {
        
        MyTilePane.getChildren().clear();
        MyTilePane.getChildren().addAll(StoreConsults.filterStoreGames(nameTextField.getText(), genreTextField.getText(),""));
        
    }

}
