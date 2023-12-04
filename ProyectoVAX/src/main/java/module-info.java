module com.cafeconpalito.proyectovax {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    
    opens com.cafeconpalito.controllers to javafx.fxml;
    exports com.cafeconpalito.proyectovax;
}
