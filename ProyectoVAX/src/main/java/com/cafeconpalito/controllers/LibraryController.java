/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cafeconpalito.controllers;

import com.cafeconpalito.consultDB.LibraryConsults;
import com.cafeconpalito.proyectovax.App;
import com.cafeconpalito.staticElements.ConectionBBDD;
import com.cafeconpalito.staticElements.MainView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.TilePane;

/**
 * FXML Controller class
 *
 * @author TerciodeMarte
 */
public class LibraryController implements Initializable {

    @FXML
    private TextField nameTextField;
    @FXML
    private ComboBox<String> priceComboBox;
    @FXML
    private TilePane MyTilePane;

    /**
     * Initializes the controller class
     * Limpia el panel central y carga instancias de los juegos del usuario
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       
        try {
            MyTilePane.getChildren().clear();
            MyTilePane.getChildren().addAll(LibraryConsults.getLibraryGames());
            priceComboBox.getItems().addAll("<Select>", "Free to Play", "-10$", "-20$");
        } catch (IOException ex) {
            Logger.getLogger(LibraryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Accion al esbribir en NameTextField que filtra por nombre y precio, al introducir caracteres
     * @param event
     * @throws IOException 
     */
    @FXML
    private void nameEntryInfo(KeyEvent event) throws IOException {
        MyTilePane.getChildren().clear();
        int auxprecio = 999;
        switch (priceComboBox.getSelectionModel().getSelectedIndex()) {
            case 0:

                auxprecio = 999;
                break;
            case 1:

                auxprecio = 0;
                break;
            case 2:

                auxprecio = 10;
                break;
            case 3:

                auxprecio = 20;
                break;

        }

        MyTilePane.getChildren().addAll(LibraryConsults.filterLibraryGames(nameTextField.getText(), auxprecio));
    }

    /**
     * Accion al seleccionar un precio en el Combo Box priceComboBox que filtra por precio y nombre, al modificar su estado
     * @param event
     * @throws IOException 
     */
    @FXML
    private void PriceSelectItem(ActionEvent event) throws IOException {
        MyTilePane.getChildren().clear();
        int auxprecio = 999;
        switch (priceComboBox.getSelectionModel().getSelectedIndex()) {
            case 0:

                auxprecio = 999;
                break;
            case 1:

                auxprecio = 0;
                break;
            case 2:

                auxprecio = 10;
                break;
            case 3:

                auxprecio = 20;
                break;

        }

        MyTilePane.getChildren().addAll(LibraryConsults.filterLibraryGames(nameTextField.getText(), auxprecio));
    }

}
