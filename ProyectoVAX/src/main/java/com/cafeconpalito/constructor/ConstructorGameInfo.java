/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeconpalito.constructor;

import com.cafeconpalito.proyectovax.App;
import java.io.IOException;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author damt207
 */
public class ConstructorGameInfo {
    
    
    private final Pane pane;
    
    private Label labelGameTitle;
    private AnchorPane PanelPadre;
    private ImageView imagen;
    private ComboBox<String> comboBox;

    public ConstructorGameInfo() throws IOException {
        //Creo el panel
        pane = new Pane(App.loadFXML("gameInfo"));
        comboBox = (ComboBox) pane.lookup("#comboBox");
        imagen = (ImageView) pane.lookup("#imagen");
        labelGameTitle = (Label) pane.lookup("#labelGameTitle");
    }

    public Label getLabelGameTitle() {
        return labelGameTitle;
    }

    public void setLabelGameTitle(Label labelGameTitle) {
        this.labelGameTitle = labelGameTitle;
    }

    public AnchorPane getPanelPadre() {
        return PanelPadre;
    }

    public void setPanelPadre(AnchorPane PanelPadre) {
        this.PanelPadre = PanelPadre;
    }

    public ImageView getImagen() {
        return imagen;
    }

    public void setImagen(ImageView imagen) {
        this.imagen = imagen;
    }

    public ComboBox<String> getComboBox() {
        return comboBox;
    }

    
    
    
    public Pane getPane() {
        return pane;
    }
    
    
    
    
    
}
