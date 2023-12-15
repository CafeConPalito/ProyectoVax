/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cafeconpalito.controllers;

import com.cafeconpalito.consultDB.GameConsults;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Ramiro
 */
public class insertGame_1Controller implements Initializable {

    @FXML
    private Label genreLabel;
    @FXML
    private ComboBox<String> genreComboBox;
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
    @FXML
    private Label pegiLabel;
    @FXML
    private Label cerfoLabel;
    @FXML
    private Label esrbLabel;
    @FXML
    private Label acbLabel;
    @FXML
    private Label uskLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        genreComboBox.getItems().addAll(GameConsults.getGenreList());

    }

    @FXML
    private void backBtn(MouseEvent event) throws IOException {

        MainView.main.setCenter(App.loadFXML("insertGame"));

    }

    @FXML
    private void tryToRegister(ActionEvent event) {
        boolean b = true;

        if (genreComboBox.getValue() == null) {
            genreLabel.setTextFill(Colors.textColorError);
            b = false;
        }
        
        if (pegi.getSelectedToggle()== null){
            pegiLabel.setTextFill(Colors.textColorError);
            b = false;
        }
        
        if (cero.getSelectedToggle()== null){
            cerfoLabel.setTextFill(Colors.textColorError);
            b = false;
        }
        
        if (esrb.getSelectedToggle()== null){
            esrbLabel.setTextFill(Colors.textColorError);
            b = false;
        }
        
        if (acb.getSelectedToggle()== null){
            acbLabel.setTextFill(Colors.textColorError);
            b = false;
        }
              
        if (usk.getSelectedToggle()== null){
            uskLabel.setTextFill(Colors.textColorError);
            b = false;
        }
        
        if (b) {
            
            System.out.println("yas taría preparado para la inserción en la base de datos");
            
            
        }

    }

    @FXML
    private void genreFocused(MouseEvent event) {
        genreLabel.setTextFill(Colors.textColor);
    }

    @FXML
    private void a1s(ActionEvent event) {
        pegiLabel.setTextFill(Colors.textColor);
    }

    @FXML
    private void a2s(ActionEvent event) {
        pegiLabel.setTextFill(Colors.textColor);
    }

    @FXML
    private void a3s(ActionEvent event) {
        pegiLabel.setTextFill(Colors.textColor);
    }

    @FXML
    private void a4s(ActionEvent event) {
        pegiLabel.setTextFill(Colors.textColor);
    }

    @FXML
    private void a5s(ActionEvent event) {
        pegiLabel.setTextFill(Colors.textColor);
    }

    @FXML
    private void a6s(ActionEvent event) {
        cerfoLabel.setTextFill(Colors.textColor);
    }

    @FXML
    private void a7s(ActionEvent event) {
        cerfoLabel.setTextFill(Colors.textColor);
    }

    @FXML
    private void a8s(ActionEvent event) {
        cerfoLabel.setTextFill(Colors.textColor);
    }

    @FXML
    private void a9s(ActionEvent event) {
        cerfoLabel.setTextFill(Colors.textColor);
    }

    @FXML
    private void a10s(ActionEvent event) {
        cerfoLabel.setTextFill(Colors.textColor);
    }

    @FXML
    private void a11s(ActionEvent event) {
         esrbLabel.setTextFill(Colors.textColor);
    }

    @FXML
    private void a12s(ActionEvent event) {
         esrbLabel.setTextFill(Colors.textColor);
    }

    @FXML
    private void a13s(ActionEvent event) {
         esrbLabel.setTextFill(Colors.textColor);
    }

    @FXML
    private void a14s(ActionEvent event) {
         esrbLabel.setTextFill(Colors.textColor);
    }

    @FXML
    private void a15s(ActionEvent event) {
         esrbLabel.setTextFill(Colors.textColor);
    }

    @FXML
    private void a16s(ActionEvent event) {
         acbLabel.setTextFill(Colors.textColor);
    }

    @FXML
    private void a17s(ActionEvent event) {
        acbLabel.setTextFill(Colors.textColor);
    }

    @FXML
    private void a18s(ActionEvent event) {
        acbLabel.setTextFill(Colors.textColor);
    }

    @FXML
    private void a19s(ActionEvent event) {
        acbLabel.setTextFill(Colors.textColor);
    }

    @FXML
    private void a20s(ActionEvent event) {
        acbLabel.setTextFill(Colors.textColor);
    }

    @FXML
    private void a21s(ActionEvent event) {
        uskLabel.setTextFill(Colors.textColor);
    }

    @FXML
    private void a22s(ActionEvent event) {
        uskLabel.setTextFill(Colors.textColor);
    }

    @FXML
    private void a23s(ActionEvent event) {
        uskLabel.setTextFill(Colors.textColor);
    }

    @FXML
    private void a24s(ActionEvent event) {
        uskLabel.setTextFill(Colors.textColor);
    }

    @FXML
    private void a25s(ActionEvent event) {
        uskLabel.setTextFill(Colors.textColor);
    }

}
