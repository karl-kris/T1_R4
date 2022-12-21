/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package t1_r4_johanssonkristian;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class Ejercicio5 {

    
    public static void main(String[] args) {
        try
        {
                System.out.println("Introduzca sus credenciales de la base de datos: \n");
                Scanner entrada = new Scanner(System.in);
                System.out.println("SGDB (Mysql): ");
                String sgdb = entrada.nextLine();
                System.out.println("Nombre de base de datos: ");
                String bd = entrada.nextLine();
                System.out.println("Nombre de usuario: ");
                String usuario = entrada.nextLine();
                System.out.println("Contraseña: ");
                String contrasena = entrada.nextLine();
                
                String servidor = "jdbc:"+sgdb+"://localhost/"+bd;
            
                Conectar conexion = new Conectar(servidor, usuario, contrasena);
                int num;
                
                System.out.println("\tElija una opción (1 - 7 / 0 para salir): \n\n");
                System.out.println("\t1. Mostrar datos generales del SGBD y la base de datos.\n");
                System.out.println("\t2. Mostrar datos de todas las tablas.\n");
                System.out.println("\t3. Mostrar los datos de una tabla.\n");
                System.out.println("\t4. Mostrar las columnas de una tabla.\n");
                System.out.println("\t5. Mostrar las claves primarias de una tabla.\n");
                System.out.println("\t6. Mostrar las claves externas asociadas a la clave primaria de una tabla.\n");
                System.out.println("\t7. Mostrar los procedimientos almacenados a la base de datos conectada.\n >");
                num = entrada.nextInt();
                
                while(num != 0){
                    
                    switch(num){
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            break;
                        case 6:
                            break;
                    }

                    System.out.println("\tElija una opción (1 - 7 / 0 para salir): \n\n");
                    System.out.println("\t1. Mostrar datos generales del SGBD y la base de datos.\n");
                    System.out.println("\t2. Mostrar datos de todas las tablas.\n");
                    System.out.println("\t3. Mostrar los datos de una tabla.\n");
                    System.out.println("\t4. Mostrar las columnas de una tabla.\n");
                    System.out.println("\t5. Mostrar las claves primarias de una tabla.\n");
                    System.out.println("\t6. Mostrar las claves externas asociadas a la clave primaria de una tabla.\n");
                    System.out.println("\t7. Mostrar los procedimientos almacenados a la base de datos conectada.\n >");

                    num = entrada.nextInt();
                
                }
                
                
                
                
                
                conexion.getConectar().close();
        }
        catch (SQLException e) {System.out.println("\nNO SE HA PODIDO CONECTAR A LA BASE DE DATOS.\nCOMPRUEBA TU CONEXIÓN.\n");}
        
    }
    
    private static void mostrarGeneral(Connection conexion){
        
        try{
        if(conexion != null){
            DatabaseMetaData datos = conexion.getMetaData();
            String nombre = datos.getDatabaseProductName();
            String driver = datos.getDriverName();
            String url = datos.getURL();
            String usuario = datos.getUserName();
            
            System.out.println("INFORMACIÓN GENERAL\n==========================\n\n");
            System.out.println("Nombre: "+nombre);
            System.out.println("Driver: "+driver);
            System.out.println("URL: "+url);
            System.out.println(" Usuario: "+usuario);
            
        }
        }catch (SQLException e) {System.out.println("\nNO SE HA PODIDO CONECTAR A LA BASE DE DATOS.\nCOMPRUEBA TU CONEXIÓN.\n");}
        
    }
    
    private static void mostrarInfoTablas(Connection conexion){
        
        if(conexion != null){
            Statement sentencia = conexion.createStatement();
            System.out.println("DATOS CURSO\n");
            
            ResultSet resul = sentencia.executeQuery("SELECT * FROM curso");
            while (resul.next())
            {
                System.out.println(resul.getInt("cod_curso") + " ------- " + resul.getString("nombre")
                + " ------- " + resul.getInt("horas") + " ------- " + resul.getString("turno") + " ------- " + resul.getString("mes_comienzo"));
            }
            
            System.out.println("\nDATOS ALUMNO\n");
            
            resul = sentencia.executeQuery("SELECT * FROM alumno");
            while (resul.next())
            {
                System.out.println(resul.getInt("cod_alumno") + " ------- " + resul.getString("dni")
                + " ------- " + resul.getString("nombre") + " ------- " + resul.getString("apellidos") + " ------- " + resul.getString("direccion")
                 + " ------- " + resul.getString("localidad") + " ------- " + resul.getString("f_nac") + " ------- " + resul.getInt("tfno"));
            }
            
            System.out.println("\nDATOS MATRÍCULA\n");
            
            resul = sentencia.executeQuery("SELECT * FROM matricula");
            while (resul.next())
            {
                System.out.println(resul.getInt("cod_curso") + " ------- " + resul.getInt("cod_alumno")
                + " ------- " + resul.getString("fecha_mat") + " ------- " + resul.getString("calificacion"));
            }
            
            sentencia.close();
        }
        
    }
    
    private static void mostrarTabla(Connection conexion, String nomTabla){
        
        if(conexion != null){
            
        }
        
    }
    
    private static void mostrarColumnasTabla(Connection conexion, String nomTabla){
        
        if(conexion != null){
            
        }
        
    }
    
    private static void mostrarPKTabla(Connection conexion, String nomTabla){
        
        if(conexion != null){
            
        }
        
    }
    
    private static void mostrarFKTabla(Connection conexion, String nomTabla){
        
        if(conexion != null){
            
        }
        
    }
    
    private static void mostrarProcedimientosAlmacenados(Connection conexion){
        
        if(conexion != null){
            
        }
        
    }
    
}
