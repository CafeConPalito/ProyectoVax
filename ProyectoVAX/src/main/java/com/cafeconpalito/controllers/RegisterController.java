/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cafeconpalito.controllers;

import com.cafeconpalito.consultDB.RegisterConsults;
import com.cafeconpalito.proyectovax.App;
import com.cafeconpalito.staticElements.Colors;
import com.cafeconpalito.staticElements.MainView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import com.cafeconpalito.registerUserData.userRegisterInfo;
import java.time.LocalDate;

/**
 * FXML Controller class
 *
 * @author CafeConPalito
 */
public class RegisterController implements Initializable {

    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField firstSurnameTextField;
    @FXML
    private TextField secondSurnameTextField;
    @FXML
    private DatePicker BirthDatePicker;
    @FXML
    private ComboBox<String> regionComboBox;
    @FXML
    private TextField emailTextField;
    @FXML
    private Label firstNameLabel;
    @FXML
    private Label firstSurnameLabel;
    @FXML
    private Label secondSurnameLabel;
    @FXML
    private Label birthDateLabel;
    @FXML
    private Label RegionLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private ImageView continueArrow;

    /**
     * Initializes the controller class. Carga los valores del combo box de las
     * regiones. Carga las persistencia del registro de usuario si los hubiera.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        regionComboBox.getItems().addAll("Europe/Asia ", "Japan", "America", "Australia", "Germany");
        regionComboBox.setVisibleRowCount(6);

        if (userRegisterInfo.getFirstName() != null) {
            firstNameTextField.setText(userRegisterInfo.getFirstName());
            firstSurnameTextField.setText(userRegisterInfo.getFirstSurname());
            secondSurnameTextField.setText(userRegisterInfo.getSecondSurname());
            BirthDatePicker.setValue((LocalDate.parse(userRegisterInfo.getBirthDate())));
            regionComboBox.setValue(userRegisterInfo.getRegion());
            emailTextField.setText(userRegisterInfo.getEmail());

        }
    }

    /**
     * Accion del Boton (next). Comprueba que los campos son correctos, si es
     * asi guarda la informacion en la percistencia del registro. Cambia la
     * vista a Register_1Controller
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void nextBtn(MouseEvent event) throws IOException {

        //Si todos los campos son correctos te deja avanzar si no es asi error!
        boolean b = true;

        if (firstNameTextField.getText().isBlank()) {
            firstNameLabel.setTextFill(Colors.textColorError);
            b = false;
        }
        if (firstSurnameTextField.getText().isBlank()) {
            firstSurnameLabel.setTextFill(Colors.textColorError);
            b = false;
        }
        if (secondSurnameTextField.getText().isBlank()) {
            secondSurnameLabel.setTextFill(Colors.textColorError);
            b = false;
        }
        if (BirthDatePicker.getValue() == null) {
            birthDateLabel.setTextFill(Colors.textColorError);
            b = false;
        }
        if (regionComboBox.getValue() == null) {
            RegionLabel.setTextFill(Colors.textColorError);
            b = false;
        }
        if (emailTextField.getText().isBlank() || !emailTextField.getText().matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$") || RegisterConsults.emailExists(emailTextField.getText())) {
            emailLabel.setTextFill(Colors.textColorError);
            b = false;
        }
        if (b) {
            userRegisterInfo.setFirstName(firstNameTextField.getText());
            userRegisterInfo.setFirstSurname(firstSurnameTextField.getText());
            userRegisterInfo.setSecondSurname(secondSurnameTextField.getText());
            userRegisterInfo.setBirthDate(BirthDatePicker.getValue().toString());
            userRegisterInfo.setRegion(regionComboBox.getValue().toString());
            userRegisterInfo.setEmail(emailTextField.getText());
            userRegisterInfo.setRegionNumber(regionComboBox.getSelectionModel().getSelectedIndex() + 1);

            MainView.main.setCenter(App.loadFXML("register_1"));
        }

    }

    /**
     * Cambia el color del label a su estado original
     *
     * @param event
     */
    @FXML
    private void firstNameFocused(MouseEvent event) {
        firstNameLabel.setTextFill(Colors.textColor);
    }

    /**
     * Cambia el color del label a su estado original
     *
     * @param event
     */
    @FXML
    private void firstSurnameFocused(MouseEvent event) {
        firstSurnameLabel.setTextFill(Colors.textColor);
    }

    /**
     * Cambia el color del label a su estado original
     *
     * @param event
     */
    @FXML
    private void secondSurnameFocused(MouseEvent event) {
        secondSurnameLabel.setTextFill(Colors.textColor);
    }

    /**
     * Cambia el color del label a su estado original
     *
     * @param event
     */
    @FXML
    private void birthDateFocused(MouseEvent event) {
        birthDateLabel.setTextFill(Colors.textColor);
    }

    /**
     * Cambia el color del label a su estado original
     *
     * @param event
     */
    @FXML
    private void emailFocused(MouseEvent event) {
        emailLabel.setTextFill(Colors.textColor);
    }

    /**
     * Cambia el color del label a su estado original
     *
     * @param event
     */
    @FXML
    private void regionFocused(MouseEvent event) {
        RegionLabel.setTextFill(Colors.textColor);
    }

}
