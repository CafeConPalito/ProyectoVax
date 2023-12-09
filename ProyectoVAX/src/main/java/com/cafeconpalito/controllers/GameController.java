/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cafeconpalito.controllers;

import com.cafeconpalito.proyectovax.App;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.TextFlow;

/**
 * FXML Controller class
 *
 * @author produccion
 */
public class GameController extends HBox {

    @FXML
    private HBox BackGround;
    @FXML
    private ImageView gameImage;
    @FXML
    private Label gameTitle;
    @FXML
    private TextFlow gamePegi;
    @FXML
    private TextFlow gameDescription;
    

    
    private int idGame;
    
    
    /**
     * Constructor sin parametros
     * Crea una instancia de Game
     */
    public GameController() throws IOException {
    
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader = App.getFXMLLoader("game");
        
        fxmlLoader.setRoot(this);
        fxmlLoader.setControllerFactory(GameController -> this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            //System.err.println(exception.getMessage());
            throw new RuntimeException(exception);
        }
        
    }
    
    /**
     * Constructor con los parametros del juego
     * Crea una instancia de Game
     */
    public GameController(int idGame) throws IOException {
    
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader = App.getFXMLLoader("game");
        
        fxmlLoader.setRoot(this);
        fxmlLoader.setControllerFactory(GameController -> this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            //System.err.println(exception.getMessage());
            throw new RuntimeException(exception);
        }
        
        this.idGame = idGame;
        
        
        
    }
    
    
    

    
}
