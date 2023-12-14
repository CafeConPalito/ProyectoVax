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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
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
    private Label genreLabel;
    @FXML
    private CheckComboBox<String> genreComboBox;
    @FXML
    private RadioButton a1;
    @FXML
    private ToggleGroup pegi;
    @FXML
    private RadioButton a2;
    @FXML
    private RadioButton a3;
    @FXML
    private RadioButton a4;
    @FXML
    private RadioButton a5;
    @FXML
    private RadioButton a6;
    @FXML
    private ToggleGroup cero;
    @FXML
    private RadioButton a7;
    @FXML
    private RadioButton a8;
    @FXML
    private RadioButton a9;
    @FXML
    private RadioButton a10;
    @FXML
    private RadioButton a11;
    @FXML
    private ToggleGroup esrb;
    @FXML
    private RadioButton a12;
    @FXML
    private RadioButton a13;
    @FXML
    private RadioButton a14;
    @FXML
    private RadioButton a15;
    @FXML
    private RadioButton a16;
    @FXML
    private ToggleGroup acb;
    @FXML
    private RadioButton a17;
    @FXML
    private RadioButton a18;
    @FXML
    private RadioButton a19;
    @FXML
    private RadioButton a20;
    @FXML
    private RadioButton a21;
    @FXML
    private ToggleGroup usk;
    @FXML
    private RadioButton a22;
    @FXML
    private RadioButton a23;
    @FXML
    private RadioButton a24;
    @FXML
    private RadioButton a25;
    @FXML
    private ImageView backArrow;
    @FXML
    private Button addGameButton;
    
    
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

    @FXML
    private void genreFocused(MouseEvent event) {
    }
    
    
    
    

    
}
