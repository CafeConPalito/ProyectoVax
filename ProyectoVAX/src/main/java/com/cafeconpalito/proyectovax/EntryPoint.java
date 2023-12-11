package com.cafeconpalito.proyectovax;

import com.cafeconpalito.staticElements.ConectionBBDD;

/**
 *
 * @author Albano Díez de Paulino
 */
public class EntryPoint {
    
    public static void main(String[] args) {
        
        //IP DONDE ESTAN LOS SERVER
        String ipServer = "192.168.34.209";
        
        //inicia la conexion Modificando la IP para la BBDD
        ConectionBBDD.modifyEM(ipServer);
        //FALTA LA CONEXION DEL SOCKET QUE LLEVARA LA MISMA IP
        
        
        App.main(args);
        
    }

}
