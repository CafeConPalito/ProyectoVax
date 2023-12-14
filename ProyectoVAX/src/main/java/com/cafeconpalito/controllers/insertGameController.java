/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cafeconpalito.controllers;

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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;
/**
 * FXML Controller class
 *
 * @author Ramiro
 */
public class insertGameController implements Initializable {

    @FXML
    private Button cancelButton;
    @FXML
    private Label titleLabel;
    @FXML
    private TextField titleTextField;
    @FXML
    private Label descriptionLabel;
    @FXML
    private TextArea descriptionTextArea;
    @FXML
    private Label priceLabel;
    @FXML
    private TextField priceTextField;
    @FXML
    private TextField imagetexField;
    @FXML
    private Button imageButton;
    @FXML
    private Label launchLabel;
    @FXML
    private DatePicker launchDateChooser;
    @FXML
    private ImageView rightArrowImage;
    @FXML
    private Label imageLabel;

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
    private void nextBtn(MouseEvent event) throws IOException {
        // aquí realizo la comprobación de los campos
        
        if(titleTextField.getText().isBlank()){
            titleLabel.setTextFill(Colors.textColorError);
        }else if (descriptionTextArea.getText().isBlank()) {
            descriptionLabel.setTextFill(Colors.textColorError);
        }else if (priceTextField.getText().isBlank()) {
            priceLabel.setTextFill(Colors.textColorError);
        }else if (imagetexField.getText().isBlank()) {
            imageLabel.setTextFill(Colors.textColorError);
        }else if (launchDateChooser.getValue() == null) {
            launchLabel.setTextFill(Colors.textColorError);
        }else{
        MainView.main.setCenter(App.loadFXML("insertGame_1"));
        }
        
    }

    @FXML
    private void CancelInsertGame(ActionEvent event) throws IOException {
        MainView.main.setCenter(App.loadFXML("store"));
    }

    @FXML
    private void titleFocused(MouseEvent event) {
        titleLabel.setTextFill(Colors.textColor);
    }

    @FXML
    private void descriptionFocused(MouseEvent event) {
        descriptionLabel.setTextFill(Colors.textColor);
    }

    @FXML
    private void priceFocused(MouseEvent event) {
        priceLabel.setTextFill(Colors.textColor);
    }

    @FXML
    private void imageFocused(MouseEvent event) {
        imageLabel.setTextFill(Colors.textColor);
    }

    @FXML
    private void dateFocused(MouseEvent event) {
        launchLabel.setTextFill(Colors.textColor);
    }

}
