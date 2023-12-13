package com.cafeconpalito.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PrimaryController {

    private double xMouse, yMouse;

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

    String operatingSystem = System.getProperty("os.name").toLowerCase();

    @FXML
    private void MinimizeButton(ActionEvent event) {
        Stage stage = (Stage) MiminizeButton.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private void MaximizeButton(ActionEvent event) {
        Stage stage = (Stage) MaximizeButton.getScene().getWindow();
        
        if (operatingSystem.contains("mac")) {
            if (stage.isFullScreen()) {
                stage.setFullScreen(false);
            } else {
                stage.setFullScreen(true);
            }
        } else {
            if (stage.isMaximized()) {
                stage.setMaximized(false);
            } else {
                stage.setMaximized(true);
            }
            
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
