package com.cafeconpalito.proyectovax;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

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
        
        scene = new Scene(loadFXML(   "primary"));
        
        
        mainStage.setResizable(true);
        //mainStage.setMaxWidth(Double.MAX_VALUE);
        //mainStage.setMaxHeight(Double.MAX_VALUE);
        mainStage.setTitle("VaX");
        mainStage.setScene(scene);
        mainStage.show();
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