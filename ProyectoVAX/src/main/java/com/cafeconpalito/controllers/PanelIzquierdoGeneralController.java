/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cafeconpalito.controllers;

import com.cafeconpalito.proyectovax.App;
import com.cafeconpalito.proyectovax.EntryPoint;
import com.cafeconpalito.staticElements.CheckURLImg;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
    @FXML
    private ImageView avatarUser;
    
    private Image imgdefault;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        imgdefault= avatarUser.getImage();
        if (UserLogedInfo.isUserIsLoged()) {
            //CARGAR INFO USUARIO
            loginBtn.setText("Log Out");
            //Cargar Alias

            alias.setText(UserLogedInfo.getAlias());
            //Cargar Avatar

            String urlavatar = "http://"+EntryPoint.getServerIP() + ":80" + EntryPoint.rutaImgUser + UserLogedInfo.getUsuarioUrlImagen();
            if (CheckURLImg.exists(urlavatar)) {
                
                avatarUser.setImage(new Image(urlavatar));
            }
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
            //LOG OUT
            UserLogedInfo.logoutUser();
            MainView.main.setCenter(App.loadFXML("store"));
            alias.setText("@guest");
            loginBtn.setText("Log In");
            System.out.println(imgdefault.getUrl());
            avatarUser.setImage(imgdefault);
           
            
        } else {
            //LOG IN
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
