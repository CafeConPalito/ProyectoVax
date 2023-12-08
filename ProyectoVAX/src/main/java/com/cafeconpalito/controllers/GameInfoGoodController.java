/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cafeconpalito.controllers;

import com.cafeconpalito.proyectovax.App;
import com.cafeconpalito.staticElements.MainView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;



/**
 * FXML Controller class
 *
 * @author produccion
 */
public class GameInfoGoodController extends HBox{

    @FXML
    private Label infoGameTitle;
    @FXML
    private ImageView infoGameImage;
    @FXML
    private Label infoGameDownloads;
    @FXML
    private Label infoGamePrice;

    //Para almacenar el id del juego con eso se puede crear la pantalla del juego al comprarlo!
    private int idGame;
        
    /**
     * Initializes the controller class.
     */
    /*
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    */
    
    
    public GameInfoGoodController() throws IOException {
        
        System.out.println("Construyendo");
        
        
        //ORIGINAL
        
        
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("gameInfoGood.fxml"));
         
         
        //FXMLLoader fxmlLoader =new FXMLLoader(getClass().getClassLoader().getResource("gameInfoGood.fxml"));
        //System.out.println("DIR CARGA = " + fxmlLoader.getLocation());

        
        
        //(App.loadFXML("store"));
        
        //FXMLLoader fxmlLoader =new FXMLLoader();
        //System.out.println(""+getClass().getResource(App.rutaRecursos("gameInfoGood")));
        //fxmlLoader.setLocation(getClass().getResource(App.rutaRecursos("gameInfoGood")));
        
        
        
        //fxmlLoader.setL
        
        //PETA
        //fxmlLoader = App.getFXMLLoader("gameInfoGood");
        
        
        System.out.println("1");
        fxmlLoader.setRoot(this);
        System.out.println("2");
        fxmlLoader.setController(this);
        System.out.println("3");
        
        System.out.println(fxmlLoader.getLocation());
        
        
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            System.err.println("AHHHHHHHHH\n");
            System.err.println(exception.getMessage());
            System.err.println("AHHHHHHHHH\n");
            
            System.out.println("peta el load");
            throw new RuntimeException(exception);
        }
        

        System.out.println("Construido");
        
        
    }
 
    
    
    @FXML
    private void switchToPurchase(ActionEvent event) {
        
    }

    public void setIdGame(int idGame) {
        this.idGame = idGame;
    }

    public Label getInfoGameTitle() {
        return infoGameTitle;
    }

    public void setInfoGameTitle(Label infoGameTitle) {
        this.infoGameTitle = infoGameTitle;
    }

    public ImageView getInfoGameImage() {
        return infoGameImage;
    }

    public void setInfoGameImage(ImageView infoGameImage) {
        this.infoGameImage = infoGameImage;
    }

    public Label getInfoGameDownloads() {
        return infoGameDownloads;
    }

    public void setInfoGameDownloads(Label infoGameDownloads) {
        this.infoGameDownloads = infoGameDownloads;
    }

    public Label getInfoGamePrice() {
        return infoGamePrice;
    }

    public void setInfoGamePrice(Label infoGamePrice) {
        this.infoGamePrice = infoGamePrice;
    }


    
    
    
}
