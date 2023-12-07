package com.cafeconpalito.controllers;

import com.cafeconpalito.proyectovax.App;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PrimaryController {

    private double xMouse,yMouse;

    @FXML
    private Button primaryButton1;
    @FXML
    private Button allGamesBtn;
    @FXML
    private Pane parent;
    @FXML
    private BorderPane layout;
    @FXML
    private HBox Header;
    @FXML
    private Button MiminizeButton;
    @FXML
    private Button MaximizeButton;
    @FXML
    private Button CloseButton;

    @FXML
    private void switchToLogIn(ActionEvent event) throws IOException {

        //Borra todo lo que este dentro del padre
        //Asi limpiamos la escena
        //parent.getChildren().clear();
        layout.setCenter(App.loadFXML("login"));

    }

    private void switchToRegister(ActionEvent event) throws IOException {

    }

    @FXML
    private void switchToStore(ActionEvent event) throws IOException {
        layout.setCenter(App.loadFXML("store"));
    }

    @FXML
    private void switchToLibrary(ActionEvent event) {
    }

    @FXML
    private void MinimizeButton(ActionEvent event) {
        Stage stage = (Stage) MiminizeButton.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private void MaximizeButton(ActionEvent event) {
        Stage stage = (Stage) MaximizeButton.getScene().getWindow();

        if (stage.isMaximized()) {
            stage.setMaximized(false);
        } else {
            stage.setMaximized(true);
        }

    }

    @FXML
    private void CloseButton(ActionEvent event) {
        Stage stage = (Stage) CloseButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void HeaderMovement(MouseEvent event) {
        Stage stage = (Stage) Header.getScene().getWindow();
        stage.setX(event.getScreenX() - xMouse);
        stage.setY(event.getScreenY() - yMouse);
    }

    @FXML
    private void HeaderClick(MouseEvent event) {
        Stage stage = (Stage) Header.getScene().getWindow();
        xMouse = event.getSceneX();
        yMouse = event.getSceneY();
        
    }

}
