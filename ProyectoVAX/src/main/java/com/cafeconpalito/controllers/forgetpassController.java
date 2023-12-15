/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cafeconpalito.controllers;

import com.cafeconpalito.consultDB.ForgetConsults;
import com.cafeconpalito.proyectovax.App;
import com.cafeconpalito.staticElements.Colors;
import com.cafeconpalito.staticElements.MainView;
import java.awt.Component;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;
/**
 * FXML Controller class
 *
 * @author TerciodeMarte
 */
public class forgetpassController implements Initializable {


    @FXML
    private Label emailLabel;
    @FXML
    private TextField emailTextField;
    @FXML
    private Label nicknameLabel;
    @FXML
    private TextField passwordTextField;
    @FXML
    private Label newPassword;
    @FXML
    private TextField pwdTextField;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }    
    
    @FXML
    private void emailTextFocused(MouseEvent event) {
        emailLabel.setTextFill(Colors.textColor);
    }


    @FXML
    private void tryRemind(ActionEvent event) {
        if (!ForgetConsults.userExists(emailTextField.getText()) || emailTextField.getText().isBlank() || !emailTextField.getText().matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
            emailLabel.setTextFill(Colors.textColorError);
        } else if (passwordTextField.getText().isBlank() || !ForgetConsults.passwordCorrect(emailTextField.getText(), "@"+passwordTextField.getText())) {
            nicknameLabel.setTextFill(Colors.textColorError);
        }else if(pwdTextField.getText().isBlank() ){
            newPassword.setTextFill(Colors.textColorError);
        }else {
            nicknameLabel.setTextFill(Colors.textColor);
            emailLabel.setTextFill(Colors.textColor);
            newPassword.setTextFill(Colors.textColor);
            ForgetConsults.updatePWD(emailTextField.getText(), pwdTextField.getText());
            showInformation(pwdTextField.getText());
           
        }
    }

    @FXML
    private void Exit(ActionEvent event) throws IOException {
        MainView.main.setCenter(App.loadFXML("store"));
    }
    
    private static void showInformation(String pass) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initStyle(StageStyle.UTILITY);
        alert.setTitle("Update Password");
        alert.setHeaderText("Update Succeeded, new password");
        alert.setContentText(pass);

        alert.showAndWait();
    }

    @FXML
    private void nickFocused(MouseEvent event) {
        nicknameLabel.setTextFill(Colors.textColor);
    }

    @FXML
    private void passTextFocused(MouseEvent event) {
        newPassword.setTextFill(Colors.textColor);
    }

}
