/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cafeconpalito.controllers;

import com.cafeconpalito.proyectovax.App;
import com.cafeconpalito.registerGameData.gameRegisterInfo;
import com.cafeconpalito.staticElements.Colors;
import com.cafeconpalito.staticElements.MainView;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.stage.FileChooser;

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
     * Carga los datos de la persistencia del registro si los hubiera
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (gameRegisterInfo.getTitle() != null) {
            titleTextField.setText(gameRegisterInfo.getTitle());
            descriptionTextArea.setText(gameRegisterInfo.getDescription());
            priceTextField.setText(gameRegisterInfo.getPrice().toString());
            imagetexField.setText(gameRegisterInfo.getImage());
            launchDateChooser.setValue((LocalDate.parse(gameRegisterInfo.getLaunchDate())));

        }
    }

    private boolean fileChooserOpened = false;

    /**
     * Lanza una ventana de Seleccion de Fichero.
     * Permitiendo al usuario cargar una imagen del juego.
     */
    private void launchFileChooser() {

        if (!fileChooserOpened) {

            fileChooserOpened = true;

            FileChooser fch = new FileChooser();
            File selected = fch.showOpenDialog(null);

            if (selected != null) {
                imagetexField.setText(selected.getAbsolutePath());
            }

            fileChooserOpened = false;
        }
    }

    /**
     * Accion del boton Select.
     * Cambia el color del label a su estado original.
     * Lanza el metodo FileChooser.
     * @param event 
     */
    @FXML
    private void SelectImage(ActionEvent event) {
        imageLabel.setTextFill(Colors.textColor);
        launchFileChooser();

    }

    /**
     * Accion del Boton (next).
     * Comprueba que los campos son correctos, si es asi guarda la informacion en la percistencia del registro.
     * Cambia la vista a insertGame_1
     * @param event
     * @throws IOException 
     */
    @FXML
    private void nextBtn(MouseEvent event) throws IOException {
        // aquí realizo la comprobación de los campos

        boolean b = true;
        if (titleTextField.getText().isBlank()) {
            titleLabel.setTextFill(Colors.textColorError);
            b = false;
        }
        if (descriptionTextArea.getText().isBlank()) {
            descriptionLabel.setTextFill(Colors.textColorError);
            b = false;
        }
        if (priceTextField.getText().isBlank() || !doubleTest(priceTextField.getText())) {
            priceLabel.setTextFill(Colors.textColorError);
            b = false;
        }
        if (imagetexField.getText().isBlank()) {
            imageLabel.setTextFill(Colors.textColorError);
            b = false;
        }
        if (launchDateChooser.getValue() == null) {
            launchLabel.setTextFill(Colors.textColorError);
            b = false;
        }

        if (b) {

            gameRegisterInfo.setTitle(titleTextField.getText());
            gameRegisterInfo.setDescription(descriptionTextArea.getText());
            gameRegisterInfo.setPrice(Double.parseDouble(priceTextField.getText()));
            gameRegisterInfo.setImage(imagetexField.getText());
            gameRegisterInfo.setLaunchDate(launchDateChooser.getValue().toString());
            
            MainView.main.setCenter(App.loadFXML("insertGame_1"));
        }

    }

    /**
     * Comprueba que el precio este en el formato correcto al pasarlo a Double.
     * @param price recibe el precio en formato String.
     * @return Devuelve True si es correcto.
     */
    private boolean doubleTest(String price) {
        try {
            Double d = Double.parseDouble(price);

            return true;
        } catch (NumberFormatException nfe) {
            //System.err.println("NumberFormatException");
            return false;
        }

    }

    /**
     * Cambia el color del label a su estado original
     * @param event 
     */
    @FXML
    private void CancelInsertGame(ActionEvent event) throws IOException {
        MainView.main.setCenter(App.loadFXML("store"));
        gameRegisterInfo.resetGameInfo();
    }

    /**
     * Cambia el color del label a su estado original
     * @param event 
     */
    @FXML
    private void titleFocused(MouseEvent event) {
        titleLabel.setTextFill(Colors.textColor);
    }

    /**
     * Cambia el color del label a su estado original
     * @param event 
     */
    @FXML
    private void descriptionFocused(MouseEvent event) {
        descriptionLabel.setTextFill(Colors.textColor);
    }

    /**
     * Cambia el color del label a su estado original
     * @param event 
     */
    @FXML
    private void priceFocused(MouseEvent event) {
        priceLabel.setTextFill(Colors.textColor);
    }

    /**
     * Cambia el color del label a su estado original
     * @param event 
     */
    @FXML
    private void imageFocused(MouseEvent event) {
        imageLabel.setTextFill(Colors.textColor);
    }

    /**
     * Cambia el color del label a su estado original
     * @param event 
     */
    @FXML
    private void dateFocused(MouseEvent event) {
        launchLabel.setTextFill(Colors.textColor);
    }

}
