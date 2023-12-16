/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cafeconpalito.controllers;

import com.cafeconpalito.consultDB.LoginConsults;
import com.cafeconpalito.proyectovax.App;
import com.cafeconpalito.staticElements.Colors;
import com.cafeconpalito.staticElements.MainView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author TerciodeMarte
 */
public class LoginController implements Initializable {

    @FXML
    private Button registerBtn;
    @FXML
    private TextField emailTextField;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private Label emailLabel;
    @FXML
    private Label passwordLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    /**
     * Accion del Boton login, comprueba que los campos Email y Password Contienen informacion correcta,
     * Consulta en la DB si existen y si todo es correcto permite logear al usuario
     * Actualizando la informacion del usuario y refrescando visualmente la informacion.
     * @param event
     * @throws IOException 
     */
    @FXML
    private void tryLogIn(ActionEvent event) throws IOException {

        if (!LoginConsults.userExists(emailTextField.getText()) || emailTextField.getText().isBlank() || !emailTextField.getText().matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
            emailLabel.setTextFill(Colors.textColorError);
        } else if (passwordTextField.getText().isBlank() || !LoginConsults.passwordCorrect(emailTextField.getText(), passwordTextField.getText())) {
            passwordLabel.setTextFill(Colors.textColorError);
        } else {
            //USER LOGEADO CARGO INFO Y LANZO LA STORE DE VUELTA
            LoginConsults.loadUserData(emailTextField.getText());
            //Dirijo a la store
            MainView.main.setCenter(App.loadFXML("store"));
            //Recargo el panel lateral
            MainView.main.setLeft(App.loadFXML("panelIzquierdoGeneral"));

        }

    }

    /**
     * Accion del boton Register, envia al usuario a la vista del registro
     * @param event
     * @throws IOException 
     */
    @FXML
    private void switchToRegister(ActionEvent event) throws IOException {
        MainView.main.setCenter(App.loadFXML("register"));
    }

    /**
     * vuelte el color del label a su estado original
     * @param event 
     */
    @FXML
    private void emailTextFocused(MouseEvent event) {
        emailLabel.setTextFill(Colors.textColor);
    }

    /**
     * vuelte el color del label a su estado original
     * @param event 
     */
    @FXML
    private void passwordTextFocused(MouseEvent event) {
        passwordLabel.setTextFill(Colors.textColor);
    }

}
