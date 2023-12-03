package com.cafeconpalito.proyectovax;

import com.cafeconpalito.constructor.ConstructorGameInfo;
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
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;

public class SecondaryController implements Initializable {

    @FXML
    private Button secondaryButton;
    @FXML
    private Button addGameButton;
    @FXML
    private TilePane MyTilePane;
    

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
}
