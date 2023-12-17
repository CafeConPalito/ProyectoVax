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
 * @author CafeConPalito
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
     * Carga la informacion en el combo Box roleComboBox.
     * Carga los datos de la persistencia el registro si los hubiera
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

    /**
     * Accion del Boton (Back).
     * Guarda la informacion en la persistecia del registro si la ubiera
     * Cambia la vista a registerController 
     * @param event
     * @throws IOException 
     */
    @FXML
    private void backBtn(MouseEvent event) throws IOException {
        
        saveData();
        MainView.main.setCenter(App.loadFXML("register"));
    }
    
    /**
     * Guarda toda la informacion de los campos completados en la persistencia de Registro.
     */
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

    /**
     * Accion de la imagen del usuario.
     * Permite seleccionar una imagen para cargar al usuario
     * Lanza el metodo FileChooser.
     * @param event 
     */
    @FXML
    private void imageClicked(MouseEvent event) {
        launchFileChooser();
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

    //Variable que controla si esta abierta ya una ventana del FileChooser
    private boolean fileChooserOpened = false;

    /**
     * Lanza una ventana de Seleccion de Fichero.
     * Permitiendo al usuario cargar una imagen de perfil.
     * Solo permite las extensiones de imagenes permitidas. 
     */
    private void launchFileChooser() {
        
        if (!fileChooserOpened) {
            
            fileChooserOpened = true;
          
            FileChooser fch = new FileChooser();

            //Configuramos el File Chooser para que solo adminta archivos de tipo imagen
            String[] extensions = {"*.png","*.jpg","*.jpeg","*.bmp","*.gif"};
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Image Files", extensions);
            fch.getExtensionFilters().add(extFilter);
            
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
        
        boolean b=true;

        if (nicknametexfield.getText().isBlank() || RegisterConsults.nickNameExists(nicknametexfield.getText())) {
            nicknameLabel.setTextFill(Colors.textColorError);
            b=false;
        }
        if (passwordtextfield.getText().isBlank()) {
            passwordLabel.setTextFill(Colors.textColorError);
            b=false;
        }
        if (rPasswordtextfield.getText().isBlank() || !rPasswordtextfield.getText().equals(passwordtextfield.getText())) {
            rPaswordLabel.setTextFill(Colors.textColorError);
            b=false;
        }
        if (imagetextfield.getText().isBlank()) {
            imageLabel.setTextFill(Colors.textColorError);
            b=false;
        }
        if (rolecombobox.getValue() == null) {
            roleLabel.setTextFill(Colors.textColorError);
            b=false;
        }
        
        if (b) {
      
            saveData();

            RegisterConsults.insercion();
            SocketImagUser siu = new SocketImagUser(userRegisterInfo.getNickname().replaceAll("\\s+",""), userRegisterInfo.getImage());
            System.out.println("registrando usuario");
            userRegisterInfo.resetRegisterInfo();
            MainView.main.setCenter(App.loadFXML("store"));

        }
    }

    /**
     * Cambia el color del label a su estado original
     * @param event 
     */
    @FXML
    private void nickNameFocused(MouseEvent event) {
        nicknameLabel.setTextFill(Colors.textColor);
    }

    /**
     * Cambia el color del label a su estado original
     * @param event 
     */
    @FXML
    private void passwordFocused(MouseEvent event) {
        passwordLabel.setTextFill(Colors.textColor);
    }

    /**
     * Cambia el color del label a su estado original
     * @param event 
     */
    @FXML
    private void imageTextfieldFocused(MouseEvent event) {
        imageLabel.setTextFill(Colors.textColor);
    }

    /**
     * Cambia el color del label a su estado original
     * @param event 
     */
    @FXML
    private void roleComboBoxFocused(MouseEvent event) {
        roleLabel.setTextFill(Colors.textColor);
    }

    /**
     * Cambia el color del label a su estado original
     * @param event 
     */
    @FXML
    private void rpasswordFocused(MouseEvent event) {
        rPaswordLabel.setTextFill(Colors.textColor);
    }

}
