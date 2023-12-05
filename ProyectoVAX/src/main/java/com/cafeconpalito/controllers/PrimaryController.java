package com.cafeconpalito.controllers;

import com.cafeconpalito.proyectovax.App;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class PrimaryController {

    @FXML
    private Button primaryButton1;
    @FXML
    private Button allGamesBtn;
    @FXML
    private Pane parent;

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private void switchToLogIn(ActionEvent event) throws IOException {

        
        parent.getChildren().add(new HBox(App.loadFXML("login")));

    }

}
