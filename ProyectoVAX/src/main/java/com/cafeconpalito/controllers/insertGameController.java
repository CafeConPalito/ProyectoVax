/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cafeconpalito.controllers;

import com.cafeconpalito.proyectovax.App;
import com.cafeconpalito.staticElements.MainView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.input.MouseEvent;
/**
 * FXML Controller class
 *
 * @author Ramiro
 */
public class insertGameController implements Initializable {

    @FXML
    private Button cancelButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void SelectImage(ActionEvent event) {
    }

    @FXML
    private void nextBtn(MouseEvent event) {
    }

    @FXML
    private void CancelInsertGame(ActionEvent event) throws IOException {
        MainView.main.setCenter(App.loadFXML("store"));
    }

}
