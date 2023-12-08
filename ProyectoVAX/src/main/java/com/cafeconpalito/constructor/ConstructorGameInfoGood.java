/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.constructor;

import com.cafeconpalito.proyectovax.App;
import java.io.IOException;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 *
 * @author produccion
 */
public class ConstructorGameInfoGood {
    
    /*
    @FXML
    private Label infoGameTitle;
    @FXML
    private ImageView infoGameImage;
    @FXML
    private Label infoGameDownloads;
    @FXML
    private Label infoGamePrice;
    */
    
    //Creo que sobra
    private final Pane pane;
    
    private int idGame;
    
    private Label infoGameTitle;
    private Label infoGameDownloads;
    private Label infoGamePrice;
    private ImageView infoGameImage; //url de la imagen
    

    public ConstructorGameInfoGood(int idGame, String title, String numDownloads, String price, String urlImage) throws IOException {
        //Creo el panel
        pane = new Pane(App.loadFXML("gameInfoGood"));
        
        //Linco la informacion de cada componente al objeto
        infoGameTitle = (Label) pane.lookup("#infoGameTitle");
        infoGameDownloads = (Label) pane.lookup("#infoGameDownloads");
        infoGamePrice = (Label) pane.lookup("#infoGamePrice");
        infoGameImage = (ImageView) pane.lookup("#infoGameImage");
        
        
        //Seteo los valores del objeto
        //this.idGame = idGame;
        infoGameTitle.setText(title);
        infoGameDownloads.setText(numDownloads);
        infoGamePrice.setText(price);
        infoGameImage.setImage(new Image(urlImage));
        
    }

    public int getIdGame() {
        return idGame;
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

    public ImageView getInfoGameImage() {
        return infoGameImage;
    }

    public void setInfoGameImage(ImageView infoGameImage) {
        this.infoGameImage = infoGameImage;
    }

    public Pane getPane() {
        return pane;
    }
    
    
    
}
