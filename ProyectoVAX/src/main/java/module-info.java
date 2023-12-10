module com.cafeconpalito.proyectovax {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;
    requires java.base;
    requires org.controlsfx.controls;
    
    
    
    //NO me borres
    //requires org.hibernate.orm.core;
    //requires java.sql;
    
    
    //OJO NO LE GUSTAN LAS BARRAS BAJAS PARA LOS NOMBRE DE LOS PAQUETES!
    opens com.cafeconpalito.userLogedData to com.cafeconpalito.proyectovax ;
    opens com.cafeconpalito.storeData to com.cafeconpalito.proyectovax ;
    opens com.cafeconpalito.entitis to com.cafeconpalito.proyectovax ;
    opens com.cafeconpalito.staticElements to com.cafeconpalito.proyectovax ;
    
    //Para que pueda leer los FXML
    opens com.cafeconpalito.controllers to javafx.fxml;
    
    
    //NO logro que abra el JAR
    opens com.cafeconpalito.proyectovax to javafx.graphics;
   
    
    exports com.cafeconpalito.proyectovax;
           
}
