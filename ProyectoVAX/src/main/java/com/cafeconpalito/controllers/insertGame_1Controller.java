/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cafeconpalito.controllers;

import com.cafeconpalito.consultDB.GameConsults;
import com.cafeconpalito.consultDB.RegulationConsults;
import com.cafeconpalito.entities.Juego;
import com.cafeconpalito.proyectovax.App;
import com.cafeconpalito.registerGameData.gameRegisterInfo;
import com.cafeconpalito.socket.SocketImagGame;
import com.cafeconpalito.staticElements.Colors;
import com.cafeconpalito.staticElements.MainView;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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

    int pegiNum = 1;

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

    int ceroNum = 6;

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

    int esrbNum = 11;

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

    int acbNum = 16;

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

    int uskNum = 21;

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
     * Carga los valores del ComboBox genre ComboBox rescatados de la DB.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        genreComboBox.getItems().addAll(GameConsults.getGenreList());

    }
    
    /**
     * Guarda toda la informacion de los campos completados en la persistencia de Registro.
     */
    private void saveData(){
        if (genreComboBox.getValue() != null) {
            gameRegisterInfo.setGenre(genreComboBox.getValue().toString());
        }
        
        gameRegisterInfo.setPegi(pegiNum);
        gameRegisterInfo.setCero(ceroNum);
        gameRegisterInfo.setAcb(acbNum);
        gameRegisterInfo.setEsrb(esrbNum);
        gameRegisterInfo.setUsk(uskNum);
        
    }

    /**
     * Accion del Boton (Back).
     * Cambia la vista a insertGame
     * @param event
     * @throws IOException 
     */
    @FXML
    private void backBtn(MouseEvent event) throws IOException {

        MainView.main.setCenter(App.loadFXML("insertGame"));

    }

    
    @FXML
    private void tryToRegister(ActionEvent event) throws IOException {
        boolean b = true;

        if (genreComboBox.getValue() == null) {
            genreLabel.setTextFill(Colors.textColorError);
            b = false;
        }
        if (pegi.getSelectedToggle() == null) {
            pegiLabel.setTextFill(Colors.textColorError);
            b = false;
        }

        if (cero.getSelectedToggle() == null) {
            cerfoLabel.setTextFill(Colors.textColorError);
            b = false;
        }

        if (esrb.getSelectedToggle() == null) {
            esrbLabel.setTextFill(Colors.textColorError);
            b = false;
        }

        if (acb.getSelectedToggle() == null) {
            acbLabel.setTextFill(Colors.textColorError);
            b = false;
        }

        if (usk.getSelectedToggle() == null) {
            uskLabel.setTextFill(Colors.textColorError);
            b = false;
        }

        if (b) {

            // insercion:
            
            GameConsults.insercion();// falta el id del usuario en el gameconsults.insercion
            
            System.out.println("Registrando juego");
            
            int idJuego=0;
            
            ArrayList <Juego> aj= GameConsults.getNewGameid(gameRegisterInfo.getTitle());
            
            for (Juego j : aj) {
                idJuego= j.getIdjuego();
            }
            
            
            //insertar imagen
            SocketImagGame sig = new SocketImagGame(gameRegisterInfo.getTitle().replaceAll("\\s+",""), gameRegisterInfo.getImage());
          
            //insercion de la tabla regulacion (conseguir id de juego creado y 
                //realizar 5 inserciones con el valor de las variables que almacenan pegi... etc + la id)
                RegulationConsults.insercion(pegiNum, idJuego);
                RegulationConsults.insercion(acbNum, idJuego);
                RegulationConsults.insercion(ceroNum, idJuego);
                RegulationConsults.insercion(esrbNum, idJuego);
                RegulationConsults.insercion(uskNum, idJuego);
            

            gameRegisterInfo.resetGameInfo();
            
            MainView.main.setCenter(App.loadFXML("store"));

        }

    }

    /**
     * Cambia el color del label a su estado original
     * @param event 
     */
    @FXML
    private void genreFocused(MouseEvent event) {
        genreLabel.setTextFill(Colors.textColor);
    }

    /**
     * Cambia el color del label a su estado original
     * @param event 
     */
    @FXML
    private void a1s(ActionEvent event) {
        pegiLabel.setTextFill(Colors.textColor);
        pegiNum = 1;
    }

    /**
     * Cambia el color del label a su estado original
     * @param event 
     */
    @FXML
    private void a2s(ActionEvent event) {
        pegiLabel.setTextFill(Colors.textColor);
        pegiNum = 2;
    }

    /**
     * Cambia el color del label a su estado original
     * @param event 
     */
    @FXML
    private void a3s(ActionEvent event) {
        pegiLabel.setTextFill(Colors.textColor);
        pegiNum = 3;
    }

    @FXML
    private void a4s(ActionEvent event) {
        pegiLabel.setTextFill(Colors.textColor);
        pegiNum = 4;
    }

    /**
     * Cambia el color del label a su estado original
     * @param event 
     */
    @FXML
    private void a5s(ActionEvent event) {
        pegiLabel.setTextFill(Colors.textColor);
        pegiNum = 5;
    }

    /**
     * Cambia el color del label a su estado original
     * @param event 
     */
    @FXML
    private void a6s(ActionEvent event) {
        cerfoLabel.setTextFill(Colors.textColor);
        ceroNum = 6;
    }

    /**
     * Cambia el color del label a su estado original
     * @param event 
     */
    @FXML
    private void a7s(ActionEvent event) {
        cerfoLabel.setTextFill(Colors.textColor);
        ceroNum = 7;
    }

    /**
     * Cambia el color del label a su estado original
     * @param event 
     */
    @FXML
    private void a8s(ActionEvent event) {
        cerfoLabel.setTextFill(Colors.textColor);
        ceroNum = 8;
    }

    @FXML
    private void a9s(ActionEvent event) {
        cerfoLabel.setTextFill(Colors.textColor);
        ceroNum = 9;
    }

    /**
     * Cambia el color del label a su estado original
     * @param event 
     */
    @FXML
    private void a10s(ActionEvent event) {
        cerfoLabel.setTextFill(Colors.textColor);
        ceroNum = 10;
    }

    /**
     * Cambia el color del label a su estado original
     * @param event 
     */
    @FXML
    private void a11s(ActionEvent event) {
        esrbLabel.setTextFill(Colors.textColor);
        esrbNum = 11;
    }

    /**
     * Cambia el color del label a su estado original
     * @param event 
     */
    @FXML
    private void a12s(ActionEvent event) {
        esrbLabel.setTextFill(Colors.textColor);
        esrbNum = 12;
    }

    /**
     * Cambia el color del label a su estado original
     * @param event 
     */
    @FXML
    private void a13s(ActionEvent event) {
        esrbLabel.setTextFill(Colors.textColor);
        esrbNum = 13;
    }

    /**
     * Cambia el color del label a su estado original
     * @param event 
     */
    @FXML
    private void a14s(ActionEvent event) {
        esrbLabel.setTextFill(Colors.textColor);
        esrbNum = 14;
    }

    /**
     * Cambia el color del label a su estado original
     * @param event 
     */
    @FXML
    private void a15s(ActionEvent event) {
        esrbLabel.setTextFill(Colors.textColor);
        esrbNum = 15;
    }

    /**
     * Cambia el color del label a su estado original
     * @param event 
     */
    @FXML
    private void a16s(ActionEvent event) {
        acbLabel.setTextFill(Colors.textColor);
        acbNum = 16;
    }

    /**
     * Cambia el color del label a su estado original
     * @param event 
     */
    @FXML
    private void a17s(ActionEvent event) {
        acbLabel.setTextFill(Colors.textColor);
        acbNum = 17;
    }

    /**
     * Cambia el color del label a su estado original
     * @param event 
     */
    @FXML
    private void a18s(ActionEvent event) {
        acbLabel.setTextFill(Colors.textColor);
        acbNum = 18;
    }

    /**
     * Cambia el color del label a su estado original
     * @param event 
     */
    @FXML
    private void a19s(ActionEvent event) {
        acbLabel.setTextFill(Colors.textColor);
        acbNum = 19;
    }

    /**
     * Cambia el color del label a su estado original
     * @param event 
     */
    @FXML
    private void a20s(ActionEvent event) {
        acbLabel.setTextFill(Colors.textColor);
        acbNum = 20;
    }

    /**
     * Cambia el color del label a su estado original
     * @param event 
     */
    @FXML
    private void a21s(ActionEvent event) {
        uskLabel.setTextFill(Colors.textColor);
        uskNum = 21;
    }

    /**
     * Cambia el color del label a su estado original
     * @param event 
     */
    @FXML
    private void a22s(ActionEvent event) {
        uskLabel.setTextFill(Colors.textColor);
        uskNum = 22;
    }

    /**
     * Cambia el color del label a su estado original
     * @param event 
     */
    @FXML
    private void a23s(ActionEvent event) {
        uskLabel.setTextFill(Colors.textColor);
        uskNum = 23;
    }
    
    /**
     * Cambia el color del label a su estado original
     * @param event 
     */
    @FXML
    private void a24s(ActionEvent event) {
        uskLabel.setTextFill(Colors.textColor);
        uskNum = 24;
    }

    /**
     * Cambia el color del label a su estado original
     * @param event 
     */
    @FXML
    private void a25s(ActionEvent event) {
        uskLabel.setTextFill(Colors.textColor);
        uskNum = 25;
    }

}
