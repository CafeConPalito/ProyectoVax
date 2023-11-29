module com.cafeconpalito.proyectovax {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.cafeconpalito.proyectovax to javafx.fxml;
    exports com.cafeconpalito.proyectovax;
}
