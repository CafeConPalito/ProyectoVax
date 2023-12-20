package com.cafeconpalito.proyectovax;

import com.cafeconpalito.staticElements.ConectionBBDD;
import com.cafeconpalito.staticElements.LoadScene;
import com.cafeconpalito.staticElements.MainView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.StageStyle;

/**
 * @author CafeConPalito
 * @author Maria Carmen Barrios Fernández
 * @author Ramiro Gutiérrez Valverde
 * @author Daniel Espinosa García
 * @author Albano Díez de Paulino
 */
public class App extends Application {

    private static Scene scene;
    

    LoadScene ls = null;
    //private static Scene loadScene;
    //private static Stage loadStage = new Stage();
    
    @Override
    public void init() throws Exception {
               
        System.out.println("Hola. Aquí empieza todo");

    }

    @Override
    public void start(Stage mainStage) throws IOException {
        
        //loadScene = new Scene(App.loadFXML("LoadScene"));
        //loadStage.setScene(loadScene);
        //loadStage.setResizable(true);
        //loadStage.initStyle(StageStyle.TRANSPARENT);
        //loadStage.getIcons().add(new Image(App.class.getResourceAsStream("images/logovax.png")));
        //loadStage.show();
               
        //Cargando Escena principal para mostrar
        scene = new Scene(loadFXML("primary"));

       

        /*
        Made by Cerveza con jarra fria
            *Topo
            *Cebo
            *Hortelano
            *Pijo^2
         */
        //SETEO EL Layout para que cualquiera pueda acceder!
        MainView.main = (BorderPane) scene.lookup("#layout");

        //Compruebo al iniciar que EM no sea nulo si lo es carga help para meter la nueva ip en caso contrario muestra Store.
        if (ConectionBBDD.getEm() == null) {
            MainView.main.setCenter(App.loadFXML("help"));
        } else {
            MainView.main.setCenter(App.loadFXML("store"));
        }

        
        //Añado la barra lateral
        MainView.main.setLeft(App.loadFXML("panelIzquierdoGeneral"));

        mainStage.setScene(scene);

        //Tamaño modificable del Stage si o no
        mainStage.setResizable(true);

        //Quito el header de windows
        mainStage.initStyle(StageStyle.TRANSPARENT);
        /*
        //Titulo Stage
        mainStage.setTitle("VaX");
         */

        //Icono Stage        
        mainStage.getIcons().add(new Image(App.class.getResourceAsStream("images/logovax.png")));

        //Mostrando Escena principal

        //loadStage.close();
        
        mainStage.show();

        //Tamaño minimo Stage
        mainStage.setMinWidth(mainStage.getWidth());
        mainStage.setMinHeight(mainStage.getHeight());

    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    //Dejar en public para que otros componentes puedan cargar la lista de fxml
    /**
     * Metodo que devuelve la ruta de un FXML y permite cargarlo
     *
     * @param fxml
     * @return
     * @throws IOException
     */
    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    /**
     * Metodo Necesario para que devuelta la ruta correcta del FXLM y poder
     * construir Objetos desde el controller
     *
     * @param fxml
     * @return
     * @throws IOException
     */
    public static FXMLLoader getFXMLLoader(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader;
    }

    @Override
    public void stop() throws Exception {
        //Cerrando las conexiones a la BBDD al salir de la aplicacion
        ConectionBBDD.close();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
