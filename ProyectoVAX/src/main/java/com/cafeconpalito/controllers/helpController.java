/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cafeconpalito.controllers;

import com.cafeconpalito.proyectovax.App;
import com.cafeconpalito.staticElements.ConectionBBDD;
import com.cafeconpalito.staticElements.MainView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author TerciodeMarte
 */
public class helpController implements Initializable {


    @FXML
    private TextField TFUrl;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void loadUrl(ActionEvent event) {
        //llamar al metodo de BBDD para actualizar la URL
        //Toca pasarle una IP una URL y un User;
        //ConectionBBDD.createCustomEM(newIP, user, pass);
        //QUEDA LIMPIAR ESTO PARA QUE Funcione bien!
    }

    @FXML
    private void remindButton(ActionEvent event) throws IOException {
        MainView.main.setCenter(App.loadFXML("forgetpass"));
    }

}
