/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cafeconpalito.controllers;

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
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author produccion
 */
public class PanelIzquierdoGeneralController implements Initializable {

    @FXML
    private Button allGamesBtn;
    @FXML
    private Button myGamesBtn;
    @FXML
    private Button loginBtn;
    @FXML
    private Label alias;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        if (UserLogedInfo.isUserIsLoged()) {
            loginBtn.setText("Log Out");
            //Cargar Alias
            alias.setText("@"+UserLogedInfo.getAlias());
            //Cargar Imagen
        } else {
            loginBtn.setText("Log In");
            alias.setText("@guest");
            
        }
    }

    @FXML
    private void switchToStore(ActionEvent event) throws IOException {

        MainView.main.setCenter(App.loadFXML("store"));

    }

    @FXML
    private void switchToLibrary(ActionEvent event) throws IOException {

        if (UserLogedInfo.isUserIsLoged()) {
            //TODO: AÑADIR PESTAÑA BIBLIOTECA
        } else {
            MainView.main.setCenter(App.loadFXML("login"));
        }

    }

    @FXML
    private void switchToLogIn(ActionEvent event) throws IOException {

        if (UserLogedInfo.isUserIsLoged()) {
            UserLogedInfo.logoutUser();
            MainView.main.setCenter(App.loadFXML("store"));
            loginBtn.setText("Log In");
            alias.setText("@guest");
        } else {
            MainView.main.setCenter(App.loadFXML("login"));
        }
    }

    @FXML
    private void switchToSettings(ActionEvent event) throws IOException {

        if (UserLogedInfo.isUserIsLoged()) {
            //System.out.println("el usuario esta logeado");
        } else {
            //System.out.println("el usuaroio no esta logueado");
            MainView.main.setCenter(App.loadFXML("login"));
        }

    }

    @FXML
    private void switchToHelp(ActionEvent event) throws IOException {
        MainView.main.setCenter(App.loadFXML("help"));
    }

}
