/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.cafeconpalito.controllers;

import com.cafeconpalito.consultDB.GameConsults;
import com.cafeconpalito.entities.Juego;
import com.cafeconpalito.entities.Regulacion;
import com.cafeconpalito.proyectovax.App;
import com.cafeconpalito.proyectovax.EntryPoint;
import com.cafeconpalito.staticElements.CheckURLImg;
import com.cafeconpalito.staticElements.ConectionBBDD;
import com.cafeconpalito.staticElements.MainView;
import com.cafeconpalito.userLogedData.UserLogedInfo;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * FXML Controller class
 *
 * @author CafeConPalito
 */
public class GameController extends HBox {

    private int idGame; // ID del juego rescatado de la DB

    @FXML
    private HBox BackGround;
    @FXML
    private ImageView gameImage;
    @FXML
    private Label gameTitle;
    @FXML
    private TextFlow gameDescription;
    @FXML
    private Label showGenre;
    @FXML
    private Label showReleased;
    @FXML
    private Label showRegulation;
    @FXML
    private Label showPrice;
    @FXML
    private Label showDownloads;
    @FXML
    private Button cancelButton;
    @FXML
    private Button downloadButton;

    /**
     * Constructor sin parametros Crea una instancia de Game
     * NO SE USA EN EL PROYECTO
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
     * Constructor con los parametros del ID del juego Crea una instancia del
     * GameController
     * rescatando de la base de datos toda la informacion que necesita
     *
     * @param idGame id del juego
     * @throws java.io.IOException
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
        ArrayList<Juego> l = GameConsults.getGameData(idGame);
        this.gameTitle.setText(l.get(0).getTitulo().toUpperCase());
        for (Regulacion r : l.get(0).getRegulacionCollection()) {
            //System.out.println("region" + r.getRegion());
            //System.out.println("nivel" + r.getNivel());
            if (r.getRegion() == UserLogedInfo.getRegion()) {
                this.showRegulation.setText(r.getNivel());
                break;
            } else if (r.getRegion() == 1) {
                this.showRegulation.setText(r.getNivel());
            }
        }

        /*for (Genero g : l.get(0).getGeneroCollection()) {
            System.out.println("nombre" + g.getName());
            this.showGenre.setText(g.getName());
        }*/
        // Albano se ilumina e introduce un lambda :)
        //Por una vez que se me enciende la bombilla y lo deja por escrito
        //Igual por eso lo deja Ramiro por escrito
        l.get(0).getGeneroCollection().forEach(g -> {
            this.showGenre.setText(g.getName());
        });

        this.showDownloads.setText(l.get(0).getNumdescargas().toString());
        this.showReleased.setText(l.get(0).getFecha().toString());
        this.showPrice.setText(l.get(0).getPrecio().toString() + " $");
        Font font = new Font("System", 30);
        Text textoDescripccion = new Text(l.get(0).getDescripcion());
        textoDescripccion.setFont(font);
        this.gameDescription.getChildren().add(textoDescripccion);

        String urlImagen = "http://" + EntryPoint.getServerIP() + ":80" + EntryPoint.rutaImgGame + l.get(0).getImagen();

        if (CheckURLImg.exists(urlImagen)) {
            this.gameImage.setImage(new Image(urlImagen));
        }

        //Habilito el boton de download si hay alguien logueado
        downloadButton.setDisable(!UserLogedInfo.isUserIsLoged());

    }

    /**
     * Accion del boton de cancel, te devuelve a la vista Store
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void cancelEvent(ActionEvent event) throws IOException {
        MainView.main.setCenter(App.loadFXML("store"));
    }

    /**
     * Accion del boton download, añadel el juego a la libreria en la DB par el
     * usuario y cambia la bista a la libreria
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void downloadEvent(ActionEvent event) throws IOException {
        downloadInsert();
        MainView.main.setCenter(App.loadFXML("library"));
    }

    /**
     * Realiza la insercion en la DB del juego y el usuario en la biblioteca
     */
    private void downloadInsert() {
        EntityManager em = ConectionBBDD.getEm();

        //Sentencia a cañon, no me pilla el cambio
        Query insercion = em.createNativeQuery("INSERT INTO biblioteca(idusuario,idjuego,fecha) values (:idusuario,:idjuego,:fecha);");
        em.getTransaction().begin();

        insercion.setParameter("idusuario", UserLogedInfo.getUserID());
        insercion.setParameter("idjuego", this.idGame);
        insercion.setParameter("fecha", ZonedDateTime.now().getYear() + "-" + ZonedDateTime.now().getMonthValue() + "-" + ZonedDateTime.now().getDayOfMonth());

        insercion.executeUpdate();
        em.clear();
        em.getTransaction().commit();

    }

}
