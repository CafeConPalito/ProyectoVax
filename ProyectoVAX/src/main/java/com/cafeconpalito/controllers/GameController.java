/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cafeconpalito.controllers;

import com.cafeconpalito.consultDB.GameConsults;
import com.cafeconpalito.entities.Juego;
import com.cafeconpalito.proyectovax.App;
import com.cafeconpalito.proyectovax.EntryPoint;
import com.cafeconpalito.socket.SocketImagGame;
import com.cafeconpalito.staticElements.CheckURLImg;
import com.cafeconpalito.userLogedData.UserLogedInfo;
import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
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
     * Constructor sin parametros Crea una instancia de Game
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
     * Constructor con los parametros del juego Crea una instancia de Game
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
        ArrayList<Juego> l=  GameConsults.getGameData(idGame);
        this.gameTitle.setText(l.get(0).getTitulo());
        Text textoDescripccion = new Text(l.get(0).getDescripcion());
        this.gameDescription.getChildren().add(textoDescripccion);
        
        String urlImagen = "http://"+EntryPoint.getServerIP() + ":80" + EntryPoint.rutaImgGame + l.get(0).getImagen();
        
        if(CheckURLImg.exists(urlImagen)){
            this.gameImage.setImage(new Image(urlImagen));
        }
        
    }

}
