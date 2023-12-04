module com.cafeconpalito.proyectovax {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires java.base;
    
    opens com.cafeconpalito.controllers to javafx.fxml;
    exports com.cafeconpalito.proyectovax;
}
