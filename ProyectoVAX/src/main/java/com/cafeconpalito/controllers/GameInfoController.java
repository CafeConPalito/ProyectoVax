/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cafeconpalito.controllers;

import com.cafeconpalito.proyectovax.App;
import com.cafeconpalito.staticElements.CheckURLImg;
import com.cafeconpalito.staticElements.MainView;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author CafeConPalito
 */
public class GameInfoController extends HBox {

    private int idGame; // ID del juego rescatado de la DB

    @FXML
    private Label infoGameTitle;
    @FXML
    private ImageView infoGameImage;
    @FXML
    private Label infoGameDownloads;
    @FXML
    private Label infoGamePrice;
    @FXML
    private HBox BackGroundTrans;
    @FXML
    private Button PurchaseButton;

    /**
     * Constructor sin parametros de una instancia de GameInfoController NO SE
     * USA EN EL PROYECTO
     *
     * @throws IOException
     */
    public GameInfoController() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setRoot(this);
        fxmlLoader.setControllerFactory(GameInfoController -> this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
            throw new RuntimeException(exception);
        }

    }

    /**
     * Constructor con parametros para crear una instancia de GameInfoController
     *
     * @param idGame id del juego
     * @param title titulo del juego
     * @param numDownloads numero de descargas
     * @param price precio del juego
     * @param urlImage url de la imagen, se comprueba si la url es validas
     * @throws IOException
     */
    public GameInfoController(int idGame, String title, String numDownloads, String price, String urlImage) throws IOException {

        //Construyo el objeto
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader = App.getFXMLLoader("gameInfo");
        fxmlLoader.setRoot(this);

        fxmlLoader.setControllerFactory(GameInfoController -> this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
            throw new RuntimeException(exception);
        }

        //Seteo los parametros
        this.idGame = idGame;
        infoGameTitle.setText(title);
        infoGameDownloads.setText(numDownloads);
        infoGamePrice.setText(price);

        //Comprueba si la URL DE LA IMAGEN ES CORRECTA si es asi carga la imagen sino pa fuera!
        if (CheckURLImg.exists(urlImage)) {
            infoGameImage.setImage(new Image(urlImage));
        }

    }

    /**
     * accion del boton Purchase, que crea una instancia de GameController con
     * el ID del juego
     *
     * @param event
     */
    @FXML
    private void switchToPurchase(ActionEvent event) throws IOException {

        GameController gc = new GameController(idGame);

        MainView.main.setCenter(gc);

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

    public Button getPurchaseButton() {
        return PurchaseButton;
    }

    public void setPurchaseButton(Button PurchaseButton) {
        this.PurchaseButton = PurchaseButton;
    }

}
