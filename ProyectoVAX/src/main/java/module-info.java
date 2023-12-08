module com.cafeconpalito.proyectovax {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires java.base;
    
    
    
    //NO me borres
    //requires org.hibernate.orm.core;
    //requires java.sql;
    
    //OJO NO LE GUSTAN LAS BARRAS BAJAS PARA LOS NOMBRE DE LOS PAQUETES!
    opens com.cafeconpalito.userLogedData to com.cafeconpalito.proyectovax ;
    
    opens com.cafeconpalito.controllers to javafx.fxml;
    exports com.cafeconpalito.proyectovax;
           
}
