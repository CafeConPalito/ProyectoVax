package com.cafeconpalito.proyectovax;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class PrimaryController {

    @FXML
    private Button primaryButton;
    @FXML
    private Font x3;
    @FXML
    private Button primaryButton1;

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
