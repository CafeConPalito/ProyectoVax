/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cafeconpalito.controllers;

import com.cafeconpalito.consultDB.StoreConsults;
import com.cafeconpalito.proyectovax.App;
import com.cafeconpalito.staticElements.MainView;
import com.cafeconpalito.userLogedData.UserLogedInfo;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
    @FXML
    private ComboBox<String> priceComboBox;
    @FXML
    private Button insertGameStoreButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            
            MyTilePane.getChildren().clear();
            MyTilePane.getChildren().addAll(StoreConsults.getStoreGames());
            priceComboBox.getItems().addAll("Free to Play", "-10$","-20$");
            
            if (UserLogedInfo.isUserIsDeveloper()) {
                insertGameStoreButton.setVisible(true);
            }else{
                insertGameStoreButton.setVisible(false);
            }
            
            
        } catch (IOException ex) {
            System.err.println("ERROR AL CARGAR LOS JUEGOS");
        }
    }

    @FXML
    private void nameEntryInfo(KeyEvent event) throws IOException {
        
        //MyTilePane.getChildren().clear();
        //MyTilePane.getChildren().addAll(StoreConsults.filterStoreGames(nameTextField.getText(), genreTextField.getText(),"30"));
        
    }

    @FXML
    private void genreEntryInfo(KeyEvent event) throws IOException {
        
        //MyTilePane.getChildren().clear();
       // MyTilePane.getChildren().addAll(StoreConsults.filterStoreGames(nameTextField.getText(), genreTextField.getText(),"30"));
        
    }

    @FXML
    private void insertGameStore(ActionEvent event) throws IOException {
        MainView.main.setCenter(App.loadFXML("insertGame"));
    }

}
