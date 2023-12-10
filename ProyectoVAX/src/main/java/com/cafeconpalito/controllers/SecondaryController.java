package com.cafeconpalito.controllers;

import com.cafeconpalito.proyectovax.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;

public class SecondaryController implements Initializable {

    @FXML
    private Button secondaryButton;
    @FXML
    private Button addGameButton;
    @FXML
    private TilePane MyTilePane;
    @FXML
    private HBox asd;
    

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    ObservableList<Pane> ol = FXCollections.observableArrayList();

    int cont = 0;

    @FXML
    private void clickAddGameButton(ActionEvent event) throws IOException {

    }

    @FXML
    private void click(MouseEvent event) {
        System.out.println("bhaskduhasdkh");
    }

    @FXML
    private void asdOut(MouseEvent event) {
        asd.setBackground(new Background(new BackgroundFill(Color.RED,CornerRadii.EMPTY,Insets.EMPTY)));
    }

    @FXML
    private void asdEnter(MouseEvent event) {
        asd.setBackground(new Background(new BackgroundFill(Color.GRAY,CornerRadii.EMPTY,Insets.EMPTY)));
    }

 
}
