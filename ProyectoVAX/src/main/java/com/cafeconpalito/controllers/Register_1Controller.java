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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
/**
 * FXML Controller class
 *
 * @author Ramiro
 */
public class Register_1Controller implements Initializable {

    
    @FXML
    private TextField nicknametexfield;
    @FXML
    private TextField passwordtextfield;
    @FXML
    private TextField rpasswordtextfield;
    @FXML
    private TextField imagetextfield;
    @FXML
    private Button selectImgButton;
    @FXML
    private ComboBox<String> rolecombobox;
    @FXML
    private ImageView backArrow;
    @FXML
    private Button registerButton;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        rolecombobox.getItems().addAll("user", "developer");
    }    
    

    @FXML
    private void backBtn(MouseEvent event) throws IOException {
        MainView.main.setCenter(App.loadFXML("register"));
    }

    @FXML
    private void imageClicked(MouseEvent event) {
    }

    @FXML
    private void SelectImage(ActionEvent event) {
    }

    @FXML
    private void tryToRegister(ActionEvent event) {
        System.out.println("intentando registrar usuario");
        
    }
    
    

}
