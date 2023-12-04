package com.cafeconpalito.controllers;

import com.cafeconpalito.constructor.ConstructorGameInfo;
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
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
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
        // TODO
        //gamesPanes = new JFXMasonryPane();
    }

    ObservableList<Pane> ol = FXCollections.observableArrayList();

    int cont = 0;
    //JFXMasonryPane root = new JFXMasonryPane();

    @FXML
    private void clickAddGameButton(ActionEvent event) throws IOException {

        cont++;

        ConstructorGameInfo giPanel = new ConstructorGameInfo();
        giPanel.getLabelGameTitle().setText("Añade titulo aqui: Nº " + cont);
        giPanel.getImagen().setImage(new Image("https://m.media-amazon.com/images/I/413OEtICMlL._AC_UF894,1000_QL80_.jpg"));

        MyTilePane.getChildren().add(giPanel.getPane());        
        
        //gamesTilePane.resize(Double.MAX_VALUE, Double.MAX_VALUE);
        //ol.add(giPanel.getPane());
        //lista.setItems(ol);
        /*
        GridPane gridPaneMain = new GridPane();
        Image image = new Image(
        
        BoardGameMain.class.getResourceAsStream("viewcontrollers/blank.png"));
        
        for (int x = 0; x <= 6; ++x) {
            Button button = ...;
            gridPaneMain.add(button, x, 0, 1, 1);
            ImageView imv = new ImageView();
            imv.setImage(image);
            final HBox pictureRegion = new HBox();
            pictureRegion.getChildren().add(imv);
            gridPaneMain.add(pictureRegion, x, 1);
        }
        
        Scene scene = new Scene(gridPaneMain, 800, 800);
         */
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
