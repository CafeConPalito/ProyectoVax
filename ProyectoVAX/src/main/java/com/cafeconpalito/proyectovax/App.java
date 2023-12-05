package com.cafeconpalito.proyectovax;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.image.Image;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void init() throws Exception {
        //aquí llamo a los métodos que INICIAN LA BASE DE DATOS . se ejecuta antes de start

        System.out.println("Hola. Aquí empieza todo");
    }

    @Override
    public void start(Stage mainStage) throws IOException {

        //Cargando Escena principal para mostrar
        scene = new Scene(loadFXML("primary"));
        mainStage.setScene(scene);
        
        //Tamaño modificable del Stage si o no
        mainStage.setResizable(true);
        //Titulo Stage
        mainStage.setTitle("VaX");
        //Icono Stage
        mainStage.getIcons().add(new Image(App.class.getResourceAsStream("images/vax games.png")));
        double width = scene.getWidth();
        double height = scene.getHeight();
        
        //Mostrando Escena principal
        mainStage.show();

        //Tamaño minimo Stage
        mainStage.setMinWidth(mainStage.getWidth());
        mainStage.setMinHeight(mainStage.getHeight());
        
        
        //PARA BORRAR
        //System.out.println(scene.getWidth() + "   " + scene.getHeight());
        //System.out.println(mainStage.getWidth() + "   " + mainStage.getHeight());
    
    }
    
    

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    //Dejar en public para que otros componentes puedan cargar la lista de fxml
    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    @Override
    public void stop() throws Exception {
        // aquí se ejecuta el código después de cerrar la aplicación. Por ejemplo CERRAR CONEXIÓN BASE DE DATOS

        // si quiero salir en otro punto del código y que se ejecute el stop() HAY QUE USAR el :
        // Platform.exit();        
    }

    public static void main(String[] args) {
        launch(args);
    }

}
