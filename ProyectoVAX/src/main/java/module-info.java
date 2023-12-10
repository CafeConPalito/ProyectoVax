module com.cafeconpalito.proyectovax {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;
    requires java.base;

    //BBDD
    requires org.hibernate.orm.core;
    requires java.sql;
    requires java.persistence;
    requires org.controlsfx.controls;
        
    //OJO NO LE GUSTAN LAS BARRAS BAJAS PARA LOS NOMBRE DE LOS PAQUETES!
    opens com.cafeconpalito.userLogedData to com.cafeconpalito.proyectovax ;
    opens com.cafeconpalito.consultDB to com.cafeconpalito.proyectovax ;
    //opens com.cafeconpalito.entities to com.cafeconpalito.proyectovax ;
    opens com.cafeconpalito.staticElements to com.cafeconpalito.proyectovax ;
    
    //Abriendo las entidades al controlador de hibernate.
    opens com.cafeconpalito.entities to org.hibernate.orm.core;
    
    //Para que pueda leer los FXML
    opens com.cafeconpalito.controllers to javafx.fxml;
    
    //NO logro que abra el JAR
    opens com.cafeconpalito.proyectovax to javafx.graphics;
   
    exports com.cafeconpalito.proyectovax;
           
}
