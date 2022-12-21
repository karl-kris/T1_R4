/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package t1_r4_johanssonkristian;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author Kristian Johansson Dougal
 */
public class Ejercicio4 {

    
    public static void main(String[] args) {
        
        try
            {
                Conectar conexion = new Conectar("jdbc:mysql://localhost/academia", "root", "1234");
                Scanner entrada = new Scanner(System.in);
                int num;
                
                System.out.println("\tElija una opción (1 - 6 / 0 para salir): \n\n");
                System.out.println("\t1. Insertar alumno.\n");
                System.out.println("\t2. Insertar curso.\n");
                System.out.println("\t3. Insertar matrícula.\n");
                System.out.println("\t4. Mostrar todos los alumnos.\n");
                System.out.println("\t5. Mostrar todos los cursos.\n");
                System.out.println("\t6. Mostrar todas las matrículas.\n >");
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

                    System.out.println("\tElija una opción (1 - 6 / 0 para salir): \n\n");
                    System.out.println("\t1. Insertar alumno.\n");
                    System.out.println("\t2. Insertar curso.\n");
                    System.out.println("\t3. Insertar matrícula.\n");
                    System.out.println("\t4. Mostrar todos los alumnos.\n");
                    System.out.println("\t5. Mostrar todos los cursos.\n");
                    System.out.println("\t6. Mostrar todas las matrículas.\n >");

                    num = entrada.nextInt();
                
                }
                
                
                
                
                
                conexion.getConectar().close();
        }
        catch (SQLException e) {System.out.println("\nNO SE HA PODIDO CONECTAR A LA BASE DE DATOS.\nCOMPRUEBA TU CONEXIÓN.\n");}
    }
    
    private void insertarAlumno(Connection conexion){
        try
        {
            String sql = "INSERT INTO alumno VALUES (?,?,?,?,?,?,?,?)"; 
                
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            
            Scanner entrada = new Scanner(System.in);
            System.out.println("Inserte el código del alumno: ");
            int cod = entrada.nextInt();
            
            System.out.println("Inserte el DNI del alumno: (8 dígitos, 1 letra)");
            String dni = entrada.nextLine();
            
            System.out.println("Inserte el nombre del alumno: ");
            String nom = entrada.nextLine();
            
            System.out.println("Inserte los apellidos del alumno: ");
            String ape = entrada.nextLine();
            
            System.out.println("Inserte la dirección del alumno: ");
            String dir = entrada.nextLine();
            
            System.out.println("Inserte la localidad del alumno: ");
            String loc = entrada.nextLine();
                     
            System.out.println("Inserte la fecha de nacimiento del alumno (formato : yyyy-mm-dd");
            String fnac = entrada.nextLine();
            
            System.out.println("Inserte el teléfono del alumno: ");
            int tfno = entrada.nextInt();
            
            sentencia.setInt(1, cod);
            sentencia.setString(2,dni);
            sentencia.setString(3,nom);
            sentencia.setString(4,ape);
            sentencia.setString(5,dir);
            sentencia.setString(6,loc);
            sentencia.setString(7,fnac);
            sentencia.setInt(8, tfno);
            int nuevoAlumno = sentencia.executeUpdate();
            
            sentencia.close();
        }
        catch (SQLException e) {System.out.println("\nHA HABIDO UN ERROR EN LA INSERCIÓN.\n");}
    }
    
    private void insertarCurso(Connection conexion){
        try
            {
            String sql = "INSERT INTO curso VALUES (?,?,?,?,?)"; 
                
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            
            Scanner entrada = new Scanner(System.in);
            System.out.println("Inserte el código del curso: ");
            int cod = entrada.nextInt();
            
            
            System.out.println("Inserte el nombre del curso: ");
            String nom = entrada.nextLine();
            
            System.out.println("Inserte las horas del curso: ");
            int horas = entrada.nextInt();
            
            System.out.println("Inserte el turno del curso: ");
            String turno = entrada.nextLine();
            
            System.out.println("Inserte el mes de comienzo del curso: ");
            String mes = entrada.nextLine();
            
            sentencia.setInt(1, cod);
            sentencia.setString(2,nom);
            sentencia.setInt(3,horas);
            sentencia.setString(4,turno);
            sentencia.setString(5,mes);
            int nuevoCurso = sentencia.executeUpdate();
            
            sentencia.close();
        }
        catch (SQLException e) {System.out.println("\nHA HABIDO UN ERROR EN LA INSERCIÓN.\n");}
    }
    
    private void insertarMatricula(Connection conexion){
        try
            {
            String sql = "INSERT INTO matricula VALUES (?,?,?,?,?)"; 
                
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            
            Scanner entrada = new Scanner(System.in);
            System.out.println("Inserte el código del curso: ");
            int codCur = entrada.nextInt();
            
            
            System.out.println("Inserte el código del alumno: ");
            int codAl = entrada.nextInt();
            
            System.out.println("Inserte la fecha de matriculación: ");
            String fechaMat = entrada.nextLine();
            
            System.out.println("Inserte la calificación: ");
            String cal = entrada.nextLine();
            
            sentencia.setInt(1, codCur);
            sentencia.setInt(2,codAl);
            sentencia.setString(3,fechaMat);
            sentencia.setString(4,cal);
            int nuevoCurso = sentencia.executeUpdate();
            
            sentencia.close();
        }
        catch (SQLException e) {System.out.println("\nHA HABIDO UN ERROR EN LA INSERCIÓN.\n");}
    }
    
    private void mostrarAlumnos(Connection conexion){
        try
            {
            Statement sentencia = conexion.createStatement();
            ResultSet resul = sentencia.executeQuery("SELECT * FROM alumno");
            while (resul.next())
            {
                System.out.println(resul.getInt("cod_alumno") + " ------- " + resul.getString("dni")
                + " ------- " + resul.getString("nombre") + " ------- " + resul.getString("apellidos") + " ------- " + resul.getString("direccion")
                 + " ------- " + resul.getString("localidad") + " ------- " + resul.getString("f_nac") + " ------- " + resul.getInt("tfno"));
            }
        }
        catch (SQLException e) {System.out.println("\nNO SE HA PODIDO CONECTAR A LA BASE DE DATOS.\nCOMPRUEBA TU CONEXIÓN.\n");}
    }
    
    private void mostrarCursos(Connection conexion){
        try
            {
            Statement sentencia = conexion.createStatement();
            ResultSet resul = sentencia.executeQuery("SELECT * FROM curso");
            while (resul.next())
            {
                System.out.println(resul.getInt("cod_curso") + " ------- " + resul.getString("nombre")
                + " ------- " + resul.getInt("horas") + " ------- " + resul.getString("turno") + " ------- " + resul.getString("mes_comienzo"));
            }
        }
        catch (SQLException e) {System.out.println("\nNO SE HA PODIDO CONECTAR A LA BASE DE DATOS.\nCOMPRUEBA TU CONEXIÓN.\n");}
    }
    
    private void mostrarMatriculas(Connection conexion){
        try
            {
            Statement sentencia = conexion.createStatement();
            ResultSet resul = sentencia.executeQuery("select curso.nombre, alumno.nombre from curso \n" +
                "join matricula on (curso.cod_curso=matricula.cod_curso) \n" +
                "join alumno on (matricula.cod_alumno=alumno.cod_alumno) order by curso.nombre;");
            while (resul.next())
            {
                System.out.println("Nombre del curso: "+ resul.getString(1) + " -------> Alumno:  " + resul.getString(2));
            }
        }
        catch (SQLException e) {System.out.println("\nNO SE HA PODIDO CONECTAR A LA BASE DE DATOS.\nCOMPRUEBA TU CONEXIÓN.\n");}
    }
}
