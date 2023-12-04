package com.cafeconpalito.controllers;

import com.cafeconpalito.proyectovax.App;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PrimaryController {

    @FXML
    private Button primaryButton1;
    @FXML
    private Button allGamesBtn;

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

}
