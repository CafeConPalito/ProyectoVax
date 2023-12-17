/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cafeconpalito.controllers;

import com.cafeconpalito.proyectovax.App;
import com.cafeconpalito.staticElements.Colors;
import com.cafeconpalito.staticElements.ConectionBBDD;
import com.cafeconpalito.staticElements.MainView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author TerciodeMarte
 */
public class helpController implements Initializable {

    @FXML
    private TextField TFUrl;
    @FXML
    private Label helpLabelForgotPass;
    @FXML
    private Button helpButtonRetorePass;
    @FXML
    private Label helpLabelServerUrl;

    /**
     * Initializes the controller class. Si al inicializar la conexion a la DB
     * es nula desactiva los botones para cambiar la contraseña
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        if (ConectionBBDD.getEm() == null) {
            helpLabelForgotPass.setVisible(false);
            helpButtonRetorePass.setVisible(false);
        }

    }

    /**
     * Accion del Boton Connect. Intenta una nueva conexion al servidor de DB
     * con una nueva IP. Si tiene exito nos envia a la Store. sino salta error.
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void loadUrl(ActionEvent event) throws IOException {
        if (!ConectionBBDD.createCustomEMonlyIP(TFUrl.getText())) {
            helpLabelServerUrl.setTextFill(Colors.textColorError);
        } else {
            MainView.main.setCenter(App.loadFXML("store"));
        }
    }

    /**
     * Accion del boton Restore. Envia al usuario a la vista Forgetpass para
     * reestrablecer la contraseña.
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void remindButton(ActionEvent event) throws IOException {
        MainView.main.setCenter(App.loadFXML("forgetpass"));
    }

    /**
     * Cambia el color del label a su estado original
     *
     * @param event
     */
    @FXML
    private void helpTextFieldURLfocus(MouseEvent event) {
        helpLabelServerUrl.setTextFill(Colors.textColor);
    }

}
