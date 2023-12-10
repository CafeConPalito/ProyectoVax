/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cafeconpalito.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import org.controlsfx.control.CheckComboBox;
/**
 * FXML Controller class
 *
 * @author Ramiro
 */
public class insertGame_1Controller implements Initializable {


    private CheckComboBox checkComboBox;
    @FXML
    private CheckComboBox<?> checkComboBox2;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        checkComboBox.getItems().add("region 1");
    }    
    
    @FXML
    private void backBtn(MouseEvent event) {
    }

    @FXML
    private void tryToRegister(ActionEvent event) {
    }
    
    
    
    

    
}
