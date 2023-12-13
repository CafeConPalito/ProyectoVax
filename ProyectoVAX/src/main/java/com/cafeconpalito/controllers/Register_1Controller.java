/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cafeconpalito.controllers;

import com.cafeconpalito.consultDB.RegisterConsults;
import com.cafeconpalito.proyectovax.App;
import com.cafeconpalito.staticElements.MainView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import com.cafeconpalito.registerUserData.userRegisterInfo;
import com.cafeconpalito.socket.SocketImagUser;
import com.cafeconpalito.staticElements.Colors;
import java.io.File;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author Ramiro
 */
public class Register_1Controller implements Initializable {

    @FXML
    private TextField nicknametexfield;
    @FXML
    private TextField passwordtextfield;
    @FXML
    private TextField imagetextfield;
    @FXML
    private Button selectImgButton;
    @FXML
    private ComboBox<String> rolecombobox;
    @FXML
    private ImageView backArrow;
    @FXML
    private Button registerButton;
    @FXML
    private Label nicknameLabel;
    @FXML
    private Label passwordLabel;
    @FXML
    private Label rPaswordLabel;
    @FXML
    private TextField rPasswordtextfield;
    @FXML
    private ImageView defaultImage;
    @FXML
    private Label imageLabel;
    @FXML
    private Label roleLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        rolecombobox.getItems().addAll("developer", "user");
        rolecombobox.setVisibleRowCount(3);

        if (userRegisterInfo.getNickname() != null) {
            nicknametexfield.setText(userRegisterInfo.getNickname());
        }

        if (userRegisterInfo.getPassword() != null) {
            passwordtextfield.setText(userRegisterInfo.getPassword());
        }

        if (userRegisterInfo.getrPassword() != null) {
            rPasswordtextfield.setText(userRegisterInfo.getrPassword());
        }

        if (userRegisterInfo.getImage() != null) {
            imagetextfield.setText(userRegisterInfo.getImage());
            defaultImage.setImage(new Image("file:" + imagetextfield.getText()));
        }

        if (userRegisterInfo.getRole() != null) {
            rolecombobox.setValue(userRegisterInfo.getRole());
        }
    }

    @FXML
    private void backBtn(MouseEvent event) throws IOException {
        //incluir persistencia de datos aqui ******** aunque  no se haya relellenado todo

        saveData();

        MainView.main.setCenter(App.loadFXML("register"));

    }
    
    private void saveData(){
        if (nicknametexfield.getText() != null) {
            userRegisterInfo.setNickname(nicknametexfield.getText());
        }

        if (passwordtextfield.getText() != null) {
            userRegisterInfo.setPassword(passwordtextfield.getText());
        }

        if (rPasswordtextfield.getText() != null) {
            userRegisterInfo.setrPassword(rPasswordtextfield.getText());
        }

        if (imagetextfield.getText() != null) {
            userRegisterInfo.setImage(imagetextfield.getText());
        }

        if (rolecombobox.getValue() != null) {
            userRegisterInfo.setRole(rolecombobox.getValue().toString());
            userRegisterInfo.setRolenumber(rolecombobox.getSelectionModel().getSelectedIndex());
        }
        
        
        
    }

    @FXML
    private void imageClicked(MouseEvent event) {
        launchFileChooser();
    }

    @FXML
    private void SelectImage(ActionEvent event) {
        launchFileChooser();
    }

    private boolean fileChooserOpened = false;

    private void launchFileChooser() {
        
        if (!fileChooserOpened) {
            
            fileChooserOpened = true;
          
            FileChooser fch = new FileChooser();
            File selected = fch.showOpenDialog(null);
            
            
            
            if (selected != null) {
                imagetextfield.setText(selected.getAbsolutePath());
                defaultImage.setImage(new Image("file:" + selected.getAbsolutePath()));
            }
            
            fileChooserOpened = false;
        } 
    }
    
    private void insertNewUser(){
        
    }

    @FXML
    private void tryToRegister(ActionEvent event) throws IOException {

        if (nicknametexfield.getText().isBlank() || RegisterConsults.nickNameExists(nicknametexfield.getText())) {
            nicknameLabel.setTextFill(Colors.textColorError);

        } else if (passwordtextfield.getText().isBlank()) {
            passwordLabel.setTextFill(Colors.textColorError);

        } else if (rPasswordtextfield.getText().isBlank() || !rPasswordtextfield.getText().equals(passwordtextfield.getText())) {
            rPaswordLabel.setTextFill(Colors.textColorError);

        } else if (imagetextfield.getText().isBlank()) {
            imageLabel.setTextFill(Colors.textColorError);

        } else if (rolecombobox.getValue() == null) {
            roleLabel.setTextFill(Colors.textColorError);

        } else {
            saveData();

            RegisterConsults.insercion();
            SocketImagUser siu = new SocketImagUser(userRegisterInfo.getNickname(), userRegisterInfo.getImage());
            System.out.println("registrando usuario");
            userRegisterInfo.resetRegisterInfo();
            MainView.main.setCenter(App.loadFXML("store"));

        }
    }

    @FXML
    private void nickNameFocused(MouseEvent event) {
        nicknameLabel.setTextFill(Colors.textColor);
    }

    @FXML
    private void passwordFocused(MouseEvent event) {
        passwordLabel.setTextFill(Colors.textColor);
    }

    @FXML
    private void imageTextfieldFocused(MouseEvent event) {
        imageLabel.setTextFill(Colors.textColor);
    }

    @FXML
    private void roleComboBoxFocused(MouseEvent event) {
        roleLabel.setTextFill(Colors.textColor);
    }

    @FXML
    private void rpasswordFocused(MouseEvent event) {
        rPaswordLabel.setTextFill(Colors.textColor);
    }

}
