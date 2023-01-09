/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package t1_r4_johanssonkristian;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Kristian Johansson Dougal
 */
public class Conectar {
    
    private String servidor;
    private String usuario;
    private String clave;
    private Connection conexion;
    
    public Conectar(String servidor, String usuario, String clave){
        try
            {
            //Cargar el driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Establecemos la conexión con la base de datos
            conexion = DriverManager.getConnection
            (servidor,usuario,clave);
            
            System.out.println("Conexión exitosa.");
            
        }
        catch (ClassNotFoundException cn) {cn.printStackTrace();}
        catch (SQLException e) {System.out.println("\nNO SE HA PODIDO CONECTAR A LA BASE DE DATOS.\nCOMPRUEBA TU CONEXIÓN.\n");}
    
    }
    
    public Connection getConectar(){
        return conexion;
    }
    
}
